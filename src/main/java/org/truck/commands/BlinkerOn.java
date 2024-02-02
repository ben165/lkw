package org.truck.commands;

import org.truck.vehicle.mediator.TruckMediator;

public class BlinkerOn implements ICommand{

    TruckMediator truckMediator;

    BlinkerOn(TruckMediator truckMediator) {
        this.truckMediator = truckMediator;
    }

    @Override
    public void execute() {
        //not implemented
    }

    @Override
    public void execute(int nr1) {
        truckMediator.indicateOff();

        // 0 = left, 1 = right
        if (nr1 == 0) {
            truckMediator.indicateLeft();
        } else if (nr1 == 1) {
            truckMediator.indicateRight();
        }
    }

    @Override
    public void execute(int nr1, int nr2) {
        //not implemented
    }
}
