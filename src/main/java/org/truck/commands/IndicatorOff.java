package org.truck.commands;

import org.truck.vehicle.mediator.TruckMediator;

public class IndicatorOff implements ICommand{

    private final TruckMediator truckMediator;

    public IndicatorOff(TruckMediator truckMediator) {
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
