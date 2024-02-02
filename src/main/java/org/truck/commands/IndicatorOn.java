package org.truck.commands;

import org.truck.vehicle.mediator.TruckMediator;

public class IndicatorOn implements ICommand{

    private final TruckMediator truckMediator;

    public IndicatorOn(TruckMediator truckMediator) {
        this.truckMediator = truckMediator;
    }

    @Override
    public void execute() {
        //not implemented
    }

    @Override
    public void execute(int nr) {
        // 0 = left, 1 = right
        if (nr == 0) {
            truckMediator.indicateLeft();
        } else if (nr == 1) {
            truckMediator.indicateRight();
        }
    }

    @Override
    public void execute(int nr1, int nr2) {
        //not implemented
    }
}
