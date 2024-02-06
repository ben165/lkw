package org.truck.test;

import com.google.common.hash.Hashing;
import org.junit.jupiter.api.*;
import org.truck.CentralUnit;
import org.truck.Config;
import org.truck.Key;
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
                .hitch()
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
                .trailerCoupler()
                .loadingArea()
                .backAxles(2)
                .brakeLights()
                .tailBlinkers()
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
        truck.connectTrailerToHitch(trailer);
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
        assertTrue(truck.getFrontIndicators().isLeftBlinker());
        assertTrue(truck.getTailIndicators().isLeftBlinker());

        // Right indicators
        centralUnit.indicatorOn(RIGHT.ordinal());
        assertTrue(truck.getFrontIndicators().isRightBlinker());
        assertTrue(truck.getTailIndicators().isRightBlinker());

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

    // TEST 08 //TODO trailer connection
    // moveStraight test
    @Test()
    @Order(8)
    public void test8() {
        // turn on indicator right
        centralUnit.indicatorOn(RIGHT.ordinal());

        // Safe speed test
        centralUnit.moveStraight(100);
        assertEquals(75, truck.getEngine().getEngineSpeed());

        // indicator is now off
        assertFalse(truck.getFrontIndicators().isRightBlinker());
        assertFalse(truck.getTailIndicators().isRightBlinker());
    }

    // TEST 09 //TODO trailer connection
    // turn left test
    @Test()
    @Order(9)
    public void test9() {
        // turn left
        centralUnit.brake(25);
        centralUnit.turnLeft(15, 50);

        // indicators right are off
        assertFalse(truck.getFrontIndicators().isRightBlinker());
        assertFalse(truck.getTailIndicators().isRightBlinker());

        // indicators left are on
        assertTrue(truck.getFrontIndicators().isLeftBlinker());
        assertTrue(truck.getTailIndicators().isLeftBlinker());

        // safe speed test while turning
        centralUnit.turnLeft(15, 75);
        assertEquals(50, truck.getEngine().getEngineSpeed());
    }


    // TEST 10 //TODO trailer connection
    // turn right test
    @Test()
    @Order(10)
    public void test10() {
        // turn right
        centralUnit.brake(25);
        centralUnit.turnRight(15, 50);

        // indicators left are off
        assertFalse(truck.getFrontIndicators().isLeftBlinker());
        assertFalse(truck.getTailIndicators().isLeftBlinker());

        // indicators right are on
        assertTrue(truck.getFrontIndicators().isRightBlinker());
        assertTrue(truck.getTailIndicators().isRightBlinker());

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
}
