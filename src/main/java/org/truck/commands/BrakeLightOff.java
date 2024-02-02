package org.truck.commands;

import org.truck.vehicle.mediator.TruckMediator;

public class BrakeLightOff implements ICommand{
    private final TruckMediator truckMediator;

    public BrakeLightOff(TruckMediator truckMediator) {
        this.truckMediator = truckMediator;
    }

    @Override
    public void execute() {
        this.truckMediator.brakeLights(false);
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
