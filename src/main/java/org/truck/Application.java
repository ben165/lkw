package org.truck;

import org.truck.helper.SimpleBuilder;
import org.truck.vehicle.Trailor;
import org.truck.vehicle.Truck;
import static org.truck.helper.IndicatorEnum.*;

public class Application {
    public static void main(String[] args) {

        Truck truck = SimpleBuilder.createTruck(2);
        Trailor trailor = SimpleBuilder.createTrailer();

        CentralUnit centralUnit = new CentralUnit(truck);

        centralUnit.cameraOn();
        centralUnit.brake(20);

        System.out.println("TURN ON LEFT INDICATORS");
        centralUnit.indicatorOn(LEFT.ordinal());
        System.out.println("TURN OFF ALL INDICATORS");
        centralUnit.indicatorOff();
        System.out.println("TURN ON RIGHT INDICATORS");
        centralUnit.indicatorOn(RIGHT.ordinal());
    }
}