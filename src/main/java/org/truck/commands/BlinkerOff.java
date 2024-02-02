package org.truck.commands;

import org.truck.vehicle.mediator.TruckMediator;

public class BlinkerOff implements ICommand{

    TruckMediator truckMediator;

    BlinkerOff(TruckMediator truckMediator) {
        this.truckMediator = truckMediator;
    }
    @Override
    public void execute() {
        truckMediator.indicateOff();
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
