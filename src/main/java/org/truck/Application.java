package org.truck;

import org.truck.helper.SimpleBuilder;
import org.truck.vehicle.Trailor;
import org.truck.vehicle.Truck;

public class Application {
    public static void main(String[] args) {

        Truck truck = SimpleBuilder.createTruck(2);
        Trailor trailor = SimpleBuilder.createTrailer();

        CentralUnit centralUnit = new CentralUnit(truck);

        centralUnit.cameraOn();
        centralUnit.brake(20);

        centralUnit.indicatorOn(0);

    }
}