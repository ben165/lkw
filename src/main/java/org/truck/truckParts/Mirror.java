package org.truck.truckParts;

public class Mirror {
    Camera camera;
    Lidar lidar;

    public Mirror() {
        this.camera = new Camera();
        this.lidar = new Lidar();
    }

    public void setCameraStatus(boolean status) {
        camera.setStatus(status);
    }

    public void setLidarStatus(boolean status) {
        lidar.setStatus(status);
    }

    public boolean getCameraStatus() {
        return camera.getStatus();
    }

    public boolean getLidarStatus() {
        return lidar.getStatus();
    }


}
