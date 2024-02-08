package org.truck.cor;

import org.truck.serviceCenter.ServiceCenter;

public class CheckPart {
    ServiceCenter serviceCenter;

    public void check(Object part) {
        Checker engineChecker = new EngineChecker();
        engineChecker.setServiceCenter(serviceCenter);
        Checker sensorChecker = new SensorChecker(engineChecker);
        sensorChecker.setServiceCenter(serviceCenter);

        sensorChecker.check(part);
    }

    public void setServiceCenter(ServiceCenter serviceCenter) {
        this.serviceCenter = serviceCenter;
    }
}
