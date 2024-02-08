package org.truck.proxy;

import org.truck.truckParts.Camera;
import org.truck.truckParts.Engine;
import org.truck.truckParts.Lidar;

public class RepairRobot {

    public RepairRobot(ProxyAccess proxyAccess, Engine engine) {
        if (proxyAccess.grant()) {
            engine.setIsDamaged(false);
        }
    }

    public RepairRobot(ProxyAccess proxyAccess, Lidar lidar) {
        if (proxyAccess.grant()) {
            lidar.setIsDamaged(false);
        }
    }

    public RepairRobot(ProxyAccess proxyAccess, Camera camera) {
        if (proxyAccess.grant()) {
            camera.setIsDamaged(false);
        }
    }

}
