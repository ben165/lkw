package org.truck.helper;

import org.truck.vehicle.Trailer;
import org.truck.vehicle.Truck;

public class SimpleBuilder {
    static public Truck createTruck(int axles) {
        return new Truck.Builder()
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
    }

    static public Trailer createTrailer() {
        return new Trailer.Builder()
                .trailerMediator()
                .trailerChassis()
                .trailerCoupler()
                .loadingArea()
                .backAxles(2)
                .brakeLights()
                .tailBlinkers()
                .build();
    }
}
