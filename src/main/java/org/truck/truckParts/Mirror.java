package org.truck.truckParts;

public class Mirror {
    Camera camera;
    Lidar lidar;

    Mirror() {
        this.camera = new Camera();
        this.lidar = new Lidar();
    }
}
