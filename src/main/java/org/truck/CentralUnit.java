package org.truck;

import org.truck.commands.*;
import org.truck.observer.IPalletListener;
import org.truck.observer.ITrailerListener;
import org.truck.vehicle.Truck;
import org.truck.vehicle.mediator.TruckMediator;

public class CentralUnit implements ITrailerListener {
    private final Truck truck;
    private final Control control = new Control();
    private final TruckMediator mediator;
    private final ICommand brake;
    private final ICommand brakeLightsOff;
    private final ICommand brakeLightsOn;
    private final ICommand cameraOn;
    private final ICommand cameraOff;
    private final ICommand indicatorOn;
    private final ICommand indicatorOff;
    private final ICommand lidarOff;
    private final ICommand lidarOn;
    public CentralUnit(Truck truck) {
        this.truck = truck;
        this.mediator = truck.truckMediator;

        brake = new Brake(this.mediator);

        brakeLightsOff = new BrakeLightOff(this.mediator);
        brakeLightsOn = new BrakeLightOn(this.mediator);

        cameraOff = new CameraOff(this.mediator);
        cameraOn = new CameraOn(this.mediator);

        indicatorOff = new IndicatorOff(this.mediator);
        indicatorOn = new IndicatorOn(this.mediator);

        lidarOff = new LidarOff(this.mediator);
        lidarOn = new LidarOn(this.mediator);
    }

    public void brake(int percentage) {
        control.setCommand(brake);
        control.action(percentage);
    }

    public void brakeLightsOff() {
        control.setCommand(brakeLightsOff);
        control.action();
    }

    public void brakeLightsOn() {
        control.setCommand(brakeLightsOn);
        control.action();
    }

    public void cameraOff() {
        control.setCommand(cameraOff);
        control.action();
    }

    public void cameraOn() {
        control.setCommand(cameraOn);
        control.action();
    }

    public void indicatorOn(int side) {
        //0 = left, 1 = right
        control.setCommand(indicatorOn);
        control.action(side);
    }

    public void indicatorOff() {
        // turns of every side
        control.setCommand(indicatorOff);
        control.action();
    }

    public void lidarOff() {
        control.setCommand(lidarOff);
        control.action();
    }

    public void lidarOn() {
        control.setCommand(lidarOn);
        control.action();
    }

    public void setHitch() {

    }

    @Override
    public void trailerDetected(String s) {

    }
}
