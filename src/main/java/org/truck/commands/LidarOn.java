package org.truck.commands;

import org.truck.vehicle.mediator.TruckMediator;

public class LidarOn implements ICommand{
    TruckMediator truckMediator;

    public LidarOn(TruckMediator truckMediator) {
        this.truckMediator = truckMediator;
    }


    @Override
    public void execute() {
        this.truckMediator.camera(true);
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
