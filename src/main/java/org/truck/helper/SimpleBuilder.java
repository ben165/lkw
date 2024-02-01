package org.truck.helper;

import org.truck.vehicle.Trailor;
import org.truck.vehicle.Truck;

public class SimpleBuilder {
    static public Truck createTruck(int axles) {
        return new Truck.Builder()
                .truckMediator()
                .truckChassis()
                .connectorClutch()
                .cabin()
                .motor()
                .frontAxle()
                .backAxles(2)
                .headlights()
                .mirrors()
                .frontBlinkers()
                .tailBlinkers()
                .brakeLights()
                .build();
    }

    static public Trailor createTrailer() {
        return new Trailor.Builder()
                .trailerChassis()
                .trailerCoupler()
                .loadingArea()
                .backAxles(2)
                .brakeLights()
                .tailBlinkers()
                .build();
    }
}
