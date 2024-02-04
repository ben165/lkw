package org.truck;

import org.truck.helper.SimpleBuilder;
import org.truck.observer.TrailerDetector;
import org.truck.vehicle.Trailor;
import org.truck.vehicle.Truck;
import static org.truck.helper.PositionEnum.*;

public class Application {
    public static void main(String[] args) {

        // Builder
        Truck truck = SimpleBuilder.createTruck(2);
        Trailor trailor = SimpleBuilder.createTrailer();

        CentralUnit centralUnit = new CentralUnit(truck);

        // Command and mediator check
        centralUnit.cameraOn();
        centralUnit.brake(20);
        System.out.println("TURN ON LEFT INDICATORS");
        centralUnit.indicatorOn(LEFT.ordinal());
        System.out.println("TURN OFF ALL INDICATORS");
        centralUnit.indicatorOff();
        System.out.println("TURN ON RIGHT INDICATORS");
        centralUnit.indicatorOn(RIGHT.ordinal());

        // Trailer Connection Check
        truck.setCentralUnit(centralUnit);

        var a = centralUnit.isTrailerIsConnected();
        System.out.println(a);
        truck.connectTrailerToHitch(trailor);
        a = centralUnit.isTrailerIsConnected();
        System.out.println(a);

    }
}