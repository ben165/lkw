package org.truck.test;

import com.google.common.hash.Hashing;
import org.junit.jupiter.api.*;
import org.truck.CentralUnit;
import org.truck.Config;
import org.truck.Key;
import org.truck.cor.CheckPart;
import org.truck.proxy.ProxyAccess;
import org.truck.proxy.RepairRobot;
import org.truck.serviceCenter.*;
import org.truck.truckParts.Camera;
import org.truck.truckParts.Engine;
import org.truck.truckParts.Lidar;
import org.truck.vehicle.Trailer;
import org.truck.vehicle.Truck;

import java.nio.charset.StandardCharsets;

import static org.truck.helper.PositionEnum.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestApplication {

    private Truck truck;
    private Trailer trailer;
    CentralUnit centralUnit;


    @BeforeEach
    public void setup() {
        this.truck = new Truck.Builder()
                .truckMediator()
                .truckChassis()
                .clutch()
                .cable()
                .cabin()
                .battery()
                .engine()
                .frontAxle()
                .backAxles(2)
                .headlights()
                .mirrors()
                .frontBlinkers()
                .tailBlinkers()
                .brakeLights()
                .build();

        this.trailer = new Trailer.Builder()
                .trailerMediator()
                .trailerChassis()
                .hitch()
                .loadingArea()
                .backAxles(2)
                .brakeLights()
                .tailIndicators()
                .build();

        this.centralUnit = new CentralUnit(truck);
        truck.setCentralUnit(centralUnit);
    }

    // TEST 01
    // Builder test truck
    @Test
    @Order(1)
    public void truckBuilderTests() {
        assertTrue(truck.checkTruckBuilder());
    }

    // TEST 02
    // Builder test trailer
    @Test()
    @Order(2)
    public void test2() {
        assertTrue(trailer.checkTrailerBuilder());
    }

    // TEST 03
    // Activate
    @Test()
    @Order(3)
    public void test3() {
        Key key = new Key();

        // Turn on
        centralUnit.receiver(key.sendSignal());
        // Cams
        assertTrue(truck.getMirrors()[LEFT.ordinal()].getCamera().getIsOn());
        assertTrue(truck.getMirrors()[RIGHT.ordinal()].getCamera().getIsOn());
        // Lidars
        assertTrue(truck.getMirrors()[LEFT.ordinal()].getLidar().getIsOn());
        assertTrue(truck.getMirrors()[RIGHT.ordinal()].getLidar().getIsOn());
        // Engine
        assertTrue(truck.getEngine().isEngineOn());
        // Steering
        assertEquals(0, truck.getFrontAxle().getAngle());
    }

    // TEST 04
    // De-Activate
    @Test()
    @Order(4)
    public void test4() {
        Key key = new Key();
        // Turn on
        centralUnit.receiver(key.sendSignal());
        // Turn off
        centralUnit.receiver(key.sendSignal());

        // Cams
        assertFalse(truck.getMirrors()[LEFT.ordinal()].getCamera().getIsOn());
        assertFalse(truck.getMirrors()[RIGHT.ordinal()].getCamera().getIsOn());
        // Lidars
        assertFalse(truck.getMirrors()[LEFT.ordinal()].getLidar().getIsOn());
        assertFalse(truck.getMirrors()[RIGHT.ordinal()].getLidar().getIsOn());
        // Engine
        assertFalse(truck.getEngine().isEngineOn());
        // Steering
        assertEquals(0, truck.getFrontAxle().getAngle());

    }

    // TEST 05
    // Trailer recognised by Central unit with sensor
    @Test()
    @Order(5)
    public void test5() {
        // Trailer detection
        assertFalse(centralUnit.isTrailerIsConnected());
        truck.connectTrailerToClutch(trailer);
        assertTrue(centralUnit.isTrailerIsConnected());

        // Correct loading detection
        trailer.loadTrailer("loadingPlan.json");
        assertTrue(centralUnit.loadingResult());

        // Wrong loading detection
        trailer.loadTrailer("loadingPlanWrong.json");
        assertFalse(centralUnit.loadingResult());
    }

    // TEST 06
    // Commands
    /*
     MoveStraight (percen-
    tage), TurnLeft(degree,percentage), TurnRight (degree,percentage). von der Zentraleinheit
    werden in korrektes Verhalten umgesetzt.
    */

    @Test()
    @Order(6)
    public void test6() {
        // Left indicators
        centralUnit.indicatorOn(LEFT.ordinal());
        assertTrue(truck.getFrontIndicators().isLeftIndicator());
        assertTrue(truck.getTailIndicators().isLeftIndicator());

        // Right indicators
        centralUnit.indicatorOn(RIGHT.ordinal());
        assertTrue(truck.getFrontIndicators().isRightIndicator());
        assertTrue(truck.getTailIndicators().isRightIndicator());

        // Brake light
        centralUnit.brakeLightsOn();
        assertTrue(truck.getBrakelights()[LEFT.ordinal()].isStatus());
        assertTrue(truck.getBrakelights()[RIGHT.ordinal()].isStatus());

        // Brake light off
        centralUnit.brakeLightsOff();
        assertFalse(truck.getBrakelights()[LEFT.ordinal()].isStatus());
        assertFalse(truck.getBrakelights()[RIGHT.ordinal()].isStatus());

        // Camera on
        centralUnit.cameraOn();
        assertTrue(truck.getMirrors()[LEFT.ordinal()].getCamera().getIsOn());
        assertTrue(truck.getMirrors()[RIGHT.ordinal()].getCamera().getIsOn());

        // Camera off
        centralUnit.cameraOff();
        assertFalse(truck.getMirrors()[LEFT.ordinal()].getCamera().getIsOn());
        assertFalse(truck.getMirrors()[RIGHT.ordinal()].getCamera().getIsOn());

        // Lidar on
        centralUnit.lidarOn();
        assertTrue(truck.getMirrors()[LEFT.ordinal()].getLidar().getIsOn());
        assertTrue(truck.getMirrors()[RIGHT.ordinal()].getLidar().getIsOn());

        // Lidar off
        centralUnit.lidarOff();
        assertFalse(truck.getMirrors()[LEFT.ordinal()].getLidar().getIsOn());
        assertFalse(truck.getMirrors()[RIGHT.ordinal()].getLidar().getIsOn());

        // Brake percentage check
        centralUnit.brake(50);

        assertEquals(50, truck.getFrontAxle().getBrake());

        for (int i=0; i < truck.getBackAxles().length; i++) {
            assertEquals(50, truck.getBackAxles()[i].getBrake());
        }

        // Engine Start and shutdown
        centralUnit.engineOn();
        assertTrue(truck.getEngine().isEngineOn());
        centralUnit.engineOff();
        assertFalse(truck.getEngine().isEngineOn());

        // MoveStraight
        centralUnit.moveStraight(50);
        assertEquals(50, truck.getEngine().getEngineSpeed());
        assertEquals(0, truck.getFrontAxle().getAngle());

        // TurnLeft
        centralUnit.turnLeft(20, 30);
        assertEquals(30, truck.getEngine().getEngineSpeed());
        assertEquals(90+20, truck.getFrontAxle().getAngle());

        // TurnRight
        centralUnit.turnRight(30, 40);
        assertEquals(40, truck.getEngine().getEngineSpeed());
        assertEquals(30, truck.getFrontAxle().getAngle());
    }


    // TEST 07
    // Key Check
    @Test()
    @Order(7)
    public void test7() {
        Key key = new Key();

        String sha256Hex = Hashing.sha256()
                .hashString("Kodiak2024", StandardCharsets.UTF_8)
                .toString();

        assertEquals(sha256Hex, key.sendSignal());

        assertFalse(centralUnit.getState().getState().stateAsBoolean());
        // Turn on
        centralUnit.receiver(key.sendSignal());
        assertTrue(centralUnit.getState().getState().stateAsBoolean());
        // Turn off
        centralUnit.receiver(key.sendSignal());
        assertFalse(centralUnit.getState().getState().stateAsBoolean());

        // Trying to turn on with wrong key
        centralUnit.receiver(key.sendWrongSignal());
        assertFalse(centralUnit.getState().getState().stateAsBoolean());

        // Trying to turn off with the wrong key
        centralUnit.receiver(key.sendSignal()); //turn on
        assertTrue(centralUnit.getState().getState().stateAsBoolean());
        centralUnit.receiver(key.sendWrongSignal());
        assertTrue(centralUnit.getState().getState().stateAsBoolean());
    }

    // TEST 08
    // moveStraight test
    @Test()
    @Order(8)
    public void test8() {
        // connect trailer
        truck.connectTrailerToClutch(trailer);
        truck.connectCableToTrailer();

        // turn on indicator right
        centralUnit.indicatorOn(RIGHT.ordinal());

        // Safe speed test
        centralUnit.moveStraight(100);
        assertEquals(75, truck.getEngine().getEngineSpeed());

        // indicator is now off on truck and trailer
        assertFalse(truck.getFrontIndicators().isRightIndicator());
        assertFalse(truck.getFrontIndicators().isLeftIndicator());
        assertFalse(truck.getTailIndicators().isRightIndicator());
        assertFalse(truck.getTailIndicators().isLeftIndicator());
        assertFalse(trailer.getTailIndicators().isRightIndicator());
        assertFalse(trailer.getTailIndicators().isLeftIndicator());
    }

    // TEST 09
    // turn left test
    @Test()
    @Order(9)
    public void test9() {
        // connect trailer
        truck.connectTrailerToClutch(trailer);
        truck.connectCableToTrailer();

        // turn left
        centralUnit.brake(25);
        centralUnit.turnLeft(15, 50);

        // indicators right are off
        assertFalse(truck.getFrontIndicators().isRightIndicator());
        assertFalse(truck.getTailIndicators().isRightIndicator());
        assertFalse(trailer.getTailIndicators().isRightIndicator());

        // indicators left are on
        assertTrue(truck.getFrontIndicators().isLeftIndicator());
        assertTrue(truck.getTailIndicators().isLeftIndicator());
        assertTrue(trailer.getTailIndicators().isLeftIndicator());

        // safe speed test while turning
        centralUnit.turnLeft(15, 75);
        assertEquals(50, truck.getEngine().getEngineSpeed());
    }


    // TEST 10
    // turn right test
    @Test()
    @Order(10)
    public void test10() {
        // connect trailer
        truck.connectTrailerToClutch(trailer);
        truck.connectCableToTrailer();

        // turn right
        centralUnit.brake(25);
        centralUnit.turnRight(15, 50);

        // indicators left are off
        assertFalse(truck.getFrontIndicators().isLeftIndicator());
        assertFalse(truck.getTailIndicators().isLeftIndicator());
        assertFalse(trailer.getTailIndicators().isLeftIndicator());

        // indicators right are on
        assertTrue(truck.getFrontIndicators().isRightIndicator());
        assertTrue(truck.getTailIndicators().isRightIndicator());
        assertTrue(trailer.getTailIndicators().isRightIndicator());

        // safe speed test while turning
        centralUnit.turnRight(15, 75);
        assertEquals(50, truck.getEngine().getEngineSpeed());
    }

    // TEST 11
    // Composite energy consumption test
    @Test()
    @Order(11)
    public void test11() {

        int full = 500*100*5;

        // full battery at the beginning
        assertEquals(full, truck.getEngine().getBattery().getAvailableEnergy());

        // moveStraight
        centralUnit.moveStraight(75);
        full -= 75*2;
        assertEquals(full, truck.getEngine().getBattery().getAvailableEnergy());

        // turnLeft
        centralUnit.turnLeft(15, 50);
        full -= 50*2;
        assertEquals(full, truck.getEngine().getBattery().getAvailableEnergy());

        // turnRight
        centralUnit.turnRight(15, 40);
        full -= 40*2;
        assertEquals(full, truck.getEngine().getBattery().getAvailableEnergy());
    }

    // TEST 12
    // Visitor test
    @Test()
    @Order(12)
    public void test12() {
        // Visitor collects broken parts. For testing, we
        // change the probability for damage to 100%.
        // All visiting parts are broken now.
        // 1*engine + 2*camera = 2*lidar = 5!
        Config.DAMAGE_PERCENTAGE = 1;
        truck.checkTruckPartsWithVisitor();
        assertEquals(5, truck.getVisitor().getDamagedParts().size());
    }

    // TEST 13
    // CoR test
    @Test()
    @Order(13)
    public void test13() {
        // The CoR Code is ugly. It only filters the Team, not the category.
        // I tried hard but spend too much time already on it.
        // At the end CoR is halfway implemented and category is
        // sorted out by an if/else. :(

        ServiceCenter serviceCenter = new ServiceCenter();

        // Define damaged engine
        Engine engine = new Engine();
        engine.setIsDamaged(true);

        // CoR Part
        CheckPart checkPart = new CheckPart();
        checkPart.setServiceCenter(serviceCenter);
        checkPart.check(engine);
        // Result is saved in ServiceCenter

        var engineTeam = serviceCenter.getTeams()[serviceCenter.getTeam()];
        assertInstanceOf(EngineTeam.class, engineTeam);

        var managerNr = engineTeam.getCorrectManager("E01");
        var manager = engineTeam.getManagers()[managerNr];
        assertInstanceOf(OperationTeamManager.class, manager);

        managerNr = engineTeam.getCorrectManager("E02");
        manager = engineTeam.getManagers()[managerNr];
        assertInstanceOf(OperationTeamManager.class, manager);

        managerNr = engineTeam.getCorrectManager("E03");
        manager = engineTeam.getManagers()[managerNr];
        assertInstanceOf(EmergencyTeamManager.class, manager);



        // Define damaged camera
        Camera camera = new Camera(0);
        camera.setIsDamaged(true);

        // CoR Part
        checkPart.check(camera);

        var sensorTeam = serviceCenter.getTeams()[serviceCenter.getTeam()];
        assertInstanceOf(SensorTeam.class, sensorTeam);

        managerNr = sensorTeam.getCorrectManager("E01");
        manager = sensorTeam.getManagers()[managerNr];
        assertInstanceOf(OperationTeamManager.class, manager);

        managerNr = engineTeam.getCorrectManager("E02");
        manager = engineTeam.getManagers()[managerNr];
        assertInstanceOf(OperationTeamManager.class, manager);

        managerNr = engineTeam.getCorrectManager("E03");
        manager = engineTeam.getManagers()[managerNr];
        assertInstanceOf(EmergencyTeamManager.class, manager);


        // Define damaged lidar
        Lidar lidar = new Lidar(0);
        lidar.setIsDamaged(true);

        // CoR Part
        checkPart.check(lidar);

        sensorTeam = serviceCenter.getTeams()[serviceCenter.getTeam()];
        assertInstanceOf(SensorTeam.class, sensorTeam);

        managerNr = sensorTeam.getCorrectManager("E01");
        manager = sensorTeam.getManagers()[managerNr];
        assertInstanceOf(OperationTeamManager.class, manager);

        managerNr = engineTeam.getCorrectManager("E02");
        manager = engineTeam.getManagers()[managerNr];
        assertInstanceOf(OperationTeamManager.class, manager);

        managerNr = engineTeam.getCorrectManager("E03");
        manager = engineTeam.getManagers()[managerNr];
        assertInstanceOf(EmergencyTeamManager.class, manager);

        // Repair
        Supervisor supervisor = serviceCenter.getTeams()[serviceCenter.getTeam()].getSupervisor();
        TechnicalEngineer engineer = manager.getTechnicalEngineers()[0];

        engineer.setPassword(supervisor.getPassword());
        ProxyAccess proxyAccess = new ProxyAccess(engineer);
        new RepairRobot(proxyAccess, engine);
        assertFalse(engine.getIsDamaged());

    }

    // TEST 14
    // Event Test
    @Test()
    @Order(14)
    public void test14() {
        centralUnit.brake(25);

        centralUnit.indicatorOn(LEFT.ordinal());

        // Trailer not connected, so right indicators are off
        assertFalse(trailer.getTailIndicators().isLeftIndicator());

        // Trailer connection
        truck.connectTrailerToClutch(trailer);
        truck.connectCableToTrailer();

        // turn on left
        centralUnit.indicatorOn(LEFT.ordinal());
        // trailer
        assertTrue(trailer.getTailIndicators().isLeftIndicator());
        assertFalse(trailer.getTailIndicators().isRightIndicator());
        // truck (was already tested so we check only one)
        assertTrue(truck.getTailIndicators().isLeftIndicator());

        // turn on right
        centralUnit.indicatorOn(RIGHT.ordinal());
        //trailer
        assertTrue(trailer.getTailIndicators().isRightIndicator());
        assertFalse(trailer.getTailIndicators().isLeftIndicator());
        // truck (was already tested so we check only one)
        assertTrue(truck.getTailIndicators().isRightIndicator());

        // turn off all
        centralUnit.indicatorOff();
        assertFalse(truck.getTailIndicators().isRightIndicator());
        assertFalse(truck.getTailIndicators().isRightIndicator());

        // brakelight on
        centralUnit.brakeLightsOn();
        assertTrue(truck.getBrakelights()[LEFT.ordinal()].isStatus());
        assertTrue(truck.getBrakelights()[RIGHT.ordinal()].isStatus());
        assertTrue(trailer.getBrakelights()[LEFT.ordinal()].isStatus());
        assertTrue(trailer.getBrakelights()[RIGHT.ordinal()].isStatus());

        // brakelight off
        centralUnit.brakeLightsOff();
        assertFalse(truck.getBrakelights()[LEFT.ordinal()].isStatus());
        assertFalse(truck.getBrakelights()[RIGHT.ordinal()].isStatus());
        assertFalse(trailer.getBrakelights()[LEFT.ordinal()].isStatus());
        assertFalse(trailer.getBrakelights()[RIGHT.ordinal()].isStatus());

        // brake (percentage)
        centralUnit.brake(33);

        // check all truck brakes
        for (int i=0; i<truck.getBackAxles().length; i++) {
            assertEquals(33, truck.getBackAxles()[i].getBrake());
        }
        // check all trailer brakes
        for (int i=0; i<trailer.getBackAxles().length; i++) {
            assertEquals(33, trailer.getBackAxles()[i].getBrake());
        }

        // Disconnect communication cable
        truck.disconnectCableFromTrailer();
        // brakelight on
        centralUnit.brakeLightsOn();
        // truck brakelight still works
        assertTrue(truck.getBrakelights()[LEFT.ordinal()].isStatus());
        assertTrue(truck.getBrakelights()[RIGHT.ordinal()].isStatus());
        // but trailer won't get info anymore
        assertFalse(trailer.getBrakelights()[LEFT.ordinal()].isStatus());
        assertFalse(trailer.getBrakelights()[RIGHT.ordinal()].isStatus());
    }
}
