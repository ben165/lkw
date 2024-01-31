package org.truck.vehicle;

public class Main {
    public static void main(String[] args) {
        Truck truck = new Truck.Builder()
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

        Trailor trailor = new Trailor.Builder()
                .trailerChassis()
                .trailerCoupler()
                .loadingArea()
                .backAxles(2)
                .brakeLights()
                .tailBlinkers()
                .build();

        System.out.println(truck);

        System.out.println();

        System.out.println(trailor);
    }
}
