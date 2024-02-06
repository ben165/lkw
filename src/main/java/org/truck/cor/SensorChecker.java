package org.truck.cor;

import org.truck.truckParts.Camera;
import org.truck.truckParts.Lidar;

public class SensorChecker extends Checker implements IChecker{
    public SensorChecker(Checker successor) {
        setSuccessor(successor);
    }

    public void check(Object part) {
        if (canHandlePart(part)) {
            System.out.println("Sensor Team needs to check: " + part);
            getServiceCenter().setTeam(1);
        } else {
            super.check(part);
        }
    }

    @Override
    public boolean canHandlePart(Object part) {
        return (part == null) || (part instanceof Camera) || (part instanceof Lidar);
    }
}
