package org.truck.commands;

import org.truck.vehicle.mediator.TruckMediator;

public class LidarOff implements ICommand{
    TruckMediator truckMediator;

    public LidarOff(TruckMediator truckMediator) {
        this.truckMediator = truckMediator;
    }


    @Override
    public void execute() {
        this.truckMediator.lidar(false);
    }

    @Override
    public void execute(int nr1) {
        //not implemented
    }

    @Override
    public void execute(int nr1, int nr2) {
        //not implemented
    }
}
