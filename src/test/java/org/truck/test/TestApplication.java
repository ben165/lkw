package org.truck.test;

import org.junit.jupiter.api.*;
import org.truck.helper.SimpleBuilder;
import org.truck.vehicle.Trailor;
import org.truck.vehicle.Truck;

import static org.junit.jupiter.api.Assertions.*;

public class TestApplication {

    private Truck truck;
    private Trailor trailer;

    // SimpleBuilder creates a truck and a trailer with the Builder pattern. See in helper package class "SimpleBuilder".
    @BeforeEach
    public void setup() {
        truck = SimpleBuilder.createTruck(2);
        trailer = SimpleBuilder.createTrailer();
    }

    // This test checks if all needed objects are initialised correctly. I wrote a method in class Truck which fails if one object is null.
    @Test
    @Order(1)
    public void BuilderTests() {
        assertTrue(truck.checkTruckBuilder());
    }

    // Same with the trailer
    @Order(2)
    public void trailerBuilderCheckTest() {
        assertNotNull(trailer);
    }

}
