package org.truck.truckParts.battery;

public class Main {
    public static void main(String[] args) {

        Battery bat = new Battery();

        var temp = bat.getAvailableEnergy();
        System.out.println(temp);
        bat.unload(260000);
        temp = bat.getAvailableEnergy();
        System.out.println(temp);
    }
}
