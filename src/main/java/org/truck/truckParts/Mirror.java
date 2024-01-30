package org.truck.truckParts;

public class Mirror {
    Camera camera;
    Lidar lidar;

    public Mirror() {
        this.camera = new Camera();
        this.lidar = new Lidar();
    }
}
