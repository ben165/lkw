package org.truck.cor2;

import org.truck.truckParts.Camera;
import org.truck.truckParts.Engine;
import org.truck.truckParts.Lidar;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String... args) {
        List<String> files = buildFileList();

        Checker engineChecker = new EngineChecker();
        Checker sensorChecker = new SensorChecker(engineChecker);

        for (String fileName : files) {
            sensorChecker.parse(fileName);
        }
    }


    private static List<Object> buildObjectList() {
        List<Object> parts = new ArrayList<>();
        parts.add(new Engine());
        parts.add(new Camera(0));
        parts.add(new Lidar(0));

        return parts;
    }

    private static List<String> buildFileList() {
        List<String> files = new ArrayList<>();

        files.add("manual.txt");
        files.add("settings.xml");
        files.add("financial_data.csv");
        files.add("financial_report.doc");

        return files;
    }
}
