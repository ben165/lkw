package org.truck.commands;

import org.truck.vehicle.mediator.TruckMediator;

public class HeadlightOff implements ICommand{
    TruckMediator truckMediator;

    public HeadlightOff(TruckMediator truckMediator) {
        this.truckMediator = truckMediator;
    }
    @Override
    public void execute() {
        this.truckMediator.headLights(false);
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
