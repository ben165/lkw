package org.truck.cor;

import org.truck.serviceCenter.ServiceCenter;
import org.truck.truckParts.Camera;
import org.truck.truckParts.Engine;
import org.truck.truckParts.Lidar;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String... args) {
        test();
    }

    private static void test() {
        List<Object> parts = buildPartList();

        ServiceCenter serviceCenter = new ServiceCenter();

        Checker engineChecker = new EngineChecker();
        engineChecker.setServiceCenter(serviceCenter);
        Checker sensorChecker = new SensorChecker(engineChecker);
        sensorChecker.setServiceCenter(serviceCenter);

        for (Object part : parts) {
            sensorChecker.check(part);
        }
    }

    private static List<Object> buildPartList() {
        List<Object> parts = new ArrayList<>();
        parts.add(new Engine());
        parts.add(new Camera(0));
        parts.add(new Lidar(0));
        parts.add(new Engine());

        return parts;
    }
}
