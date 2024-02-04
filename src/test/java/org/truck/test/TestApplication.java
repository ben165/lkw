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
        truck = SimpleBuilder.createTruck(2);
        trailer = SimpleBuilder.createTrailer();
    }

    // TEST 01
    // SimpleBuilder creates a truck and a trailer with the Builder pattern. See in helper package class "SimpleBuilder".
    @Test
    @Order(1)
    public void truckBuilderTests() {
        assertTrue(truck.checkTruckBuilder());
    }

    // TEST 02
    // Same with the trailer
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
