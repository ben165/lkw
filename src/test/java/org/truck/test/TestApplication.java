package org.truck.test;

import com.google.common.hash.Hashing;
import org.junit.jupiter.api.*;
import org.truck.CentralUnit;
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
                .engine()
                .battery()
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

        // Engine Start
        centralUnit.engineOn();
        assertTrue(truck.getEngine().isEngineOn());
        centralUnit.engineOff();
        assertFalse(truck.getEngine().isEngineOn());
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

}
