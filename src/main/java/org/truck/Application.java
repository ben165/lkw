package org.truck;

import org.truck.helper.SimpleBuilder;
import org.truck.vehicle.Trailer;
import org.truck.vehicle.Truck;
import static org.truck.helper.PositionEnum.*;

public class Application {
    public static void main(String[] args) {

        // Builder
        Truck truck = SimpleBuilder.createTruck(2);
        Trailer trailer = SimpleBuilder.createTrailer();

        CentralUnit centralUnit = new CentralUnit(truck);

        // Command and mediator check
        System.out.println("\n\n!!! COMMAND AND MEDIATOR CHECK !!!\n");
        centralUnit.cameraOn();
        centralUnit.brake(20);
        System.out.println("\nTurn on: Left indicators");
        centralUnit.indicatorOn(LEFT.ordinal());
        System.out.println("\nTurn off: All indicators");
        centralUnit.indicatorOff();
        System.out.println("\nTurn on: Right indicators");
        centralUnit.indicatorOn(RIGHT.ordinal());


        System.out.println("\n\n!! TRUCK TO TRAILER CONNECTION CHECK !!\n");
        // Trailer Connection Check
        // Unfortunately, trailer needs cantralUnit for
        // adding reference to listener list
        truck.setCentralUnit(centralUnit);

        System.out.println("\nTrailer connected? Answer: " + centralUnit.isTrailerIsConnected());
        System.out.println("Connecting...");
        truck.connectTrailerToHitch(trailer);
        System.out.println("\nTrailer connected? Answer: " + centralUnit.isTrailerIsConnected());

        System.out.println("\n\n!! LOADING CHECK !!\n");

        centralUnit.loadTrailer();
    }
}