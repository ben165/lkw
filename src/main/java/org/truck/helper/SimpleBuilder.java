package org.truck.helper;

import org.truck.vehicle.Trailer;
import org.truck.vehicle.Truck;

public class SimpleBuilder {
    static public Truck createTruck(int axles) {
        return new Truck.Builder()
                .truckMediator()
                .truckChassis()
                .clutch()
                .cable()
                .cabin()
                .battery()
                .engine()
                .frontAxle()
                .backAxles(axles)
                .headlights()
                .mirrors()
                .frontBlinkers()
                .tailBlinkers()
                .brakeLights()
                .build();
    }

    static public Trailer createTrailer(int axles) {
        return new Trailer.Builder()
                .trailerMediator()
                .trailerChassis()
                .hitch()
                .loadingArea()
                .backAxles(axles)
                .brakeLights()
                .tailIndicators()
                .build();
    }
}
