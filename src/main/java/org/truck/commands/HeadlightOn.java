package org.truck.commands;

import org.truck.vehicle.mediator.TruckMediator;

public class HeadlightOn implements ICommand{
    TruckMediator truckMediator;

    public HeadlightOn(TruckMediator truckMediator) {
        this.truckMediator = truckMediator;
    }
    @Override
    public void execute() {
        this.truckMediator.headLights(true);
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
