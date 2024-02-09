package org.truck;

import org.truck.helper.SimpleBuilder;
import org.truck.vehicle.Trailer;
import org.truck.vehicle.Truck;

public class Application {
    public static void main(String[] args) {

        // Small example of using the program

        // Builder
        Truck truck = SimpleBuilder.createTruck(2);
        Trailer trailer = SimpleBuilder.createTrailer(2);

        CentralUnit centralUnit = new CentralUnit(truck);
        truck.setCentralUnit(centralUnit);

        // Connect trailer
        truck.connectTrailerToClutch(trailer);
        truck.connectCableToTrailer();

        trailer.loadTrailer("loadingPlan.json");
        centralUnit.loadingResult();

        Key key = new Key();

        // Turn on
        centralUnit.receiver(key.sendSignal());

        // Move truck
        centralUnit.engineOn();
        centralUnit.moveStraight(50);
        centralUnit.turnLeft(20, 30);
        centralUnit.engineOff();

        // Turn off
        centralUnit.receiver(key.sendSignal());
    }
}