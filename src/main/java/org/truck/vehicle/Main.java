package org.truck.vehicle;

import org.truck.helper.SimpleBuilder;

public class Main {
    public static void main(String[] args) {
        Truck truck = SimpleBuilder.createTruck(2);
        Trailer trailer = SimpleBuilder.createTrailer();

        System.out.println(truck);

        System.out.println(truck.truckMediator.toString());

        System.out.println();

        System.out.println(trailer);
    }
}
