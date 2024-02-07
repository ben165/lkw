package org.truck.helper;

import org.truck.vehicle.Trailer;
import org.truck.vehicle.Truck;

public class SimpleBuilder {
    static public Truck createTruck(int axles) {
        return new Truck.Builder()
                .truckMediator()
                .truckChassis()
                .clutch()
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
                .eventBus()
                .trailerMediator()
                .trailerChassis()
                .hitch()
                .loadingArea()
                .backAxles(2)
                .brakeLights()
                .tailIndicators()
                .build();
    }
}
