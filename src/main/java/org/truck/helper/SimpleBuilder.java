package org.truck.helper;

import org.truck.vehicle.Trailer;
import org.truck.vehicle.Truck;

public class SimpleBuilder {
    static public Truck createTruck(int axles) {
        return new Truck.Builder()
                .truckMediator()
                .truckChassis()
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
                .hitch()
                .build();
    }

    static public Trailer createTrailer() {
        return new Trailer.Builder()
                .trailerChassis()
                .trailerCoupler()
                .loadingArea()
                .backAxles(2)
                .brakeLights()
                .tailBlinkers()
                .build();
    }
}
