package org.truck.cor2;

public class SensorChecker extends Checker {
    public SensorChecker(Checker successor) {
        setSuccessor(successor);
    }

    public void parse(String fileName) {
        if (canHandleFile(fileName, ".csv")) {
            System.out.println("csv parser handling : " + fileName);
        } else {
            super.parse(fileName);
        }
    }
}
