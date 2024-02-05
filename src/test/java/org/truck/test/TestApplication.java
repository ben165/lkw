package org.truck.test;

import org.junit.jupiter.api.*;
import org.truck.helper.SimpleBuilder;
import org.truck.vehicle.Trailer;
import org.truck.vehicle.Truck;

import static org.junit.jupiter.api.Assertions.*;

public class TestApplication {

    private Truck truck;
    private Trailer trailer;


    @BeforeEach
    public void setup() {
        Truck truck = new Truck.Builder()
                .truckMediator()
                .truckChassis()
                .hitch()
                .cabin()
                .motor()
                .battery()
                .frontAxle()
                .backAxles(2)
                .headlights()
                .mirrors()
                .frontBlinkers()
                .tailBlinkers()
                .brakeLights()
                .build();

        Trailer trailer = new Trailer.Builder()
                .trailerMediator()
                .trailerChassis()
                .trailerCoupler()
                .loadingArea()
                .backAxles(2)
                .brakeLights()
                .tailBlinkers()
                .build();
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

    //TEST 03
    // Activate: Cameras on, Lidar on, Engine start, steering 0 degrees
    @Test()
    @Order(3)
    public void test3() {}

    @Test()
    @Order(4)
    public void test4() {}

    @Test()
    @Order(5)
    public void test5() {}

    @Test()
    @Order(6)
    public void test6() {}

}
