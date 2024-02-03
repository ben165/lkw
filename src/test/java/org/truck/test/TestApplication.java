package org.truck.test;

import org.junit.jupiter.api.*;
import org.truck.helper.SimpleBuilder;
import org.truck.vehicle.Trailor;
import org.truck.vehicle.Truck;

import static org.junit.jupiter.api.Assertions.*;

public class TestApplication {

    private Truck truck;
    private Trailor trailer;

    @BeforeEach
    public void setup() {
        truck = SimpleBuilder.createTruck(2);
        trailer = SimpleBuilder.createTrailer();
    }

    @Test
    @Order(1)
    public void BuilderTests() {
        assertTrue(truck.checkTruckBuilder());
    }

    @Order(2)
    public void trailerBuilderCheckTest() {
        assertNotNull(trailer);
    }

}
