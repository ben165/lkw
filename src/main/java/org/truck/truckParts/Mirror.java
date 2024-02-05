package org.truck.truckParts;

public class Mirror {
    Camera camera;
    Lidar lidar;

    public Mirror() {
        this.camera = new Camera();
        this.lidar = new Lidar();
    }

    public void setCameraStatus(boolean status) {
        camera.setIsOn(status);
    }

    public void setLidarStatus(boolean status) {
        lidar.setIsOn(status);
    }

    public boolean getCameraStatus() {
        return camera.getIsOn();
    }

    public boolean getLidarStatus() {
        return lidar.getIsOn();
    }

    public Camera getCamera() {
        return camera;
    }

    public Lidar getLidar() {
        return lidar;
    }
}
