package org.truck.vehicle.mediator;

public interface ITruckMediator {
    void indicateOff();
    void indicateRight();
    void indicateLeft();
    void brakeLights(boolean status);
    void brake(int percentage);
    void headLights(boolean status);
    void camera(boolean status);
    void lidar(boolean status);
}
