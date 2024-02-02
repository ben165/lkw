package org.truck.commands;

import org.truck.vehicle.mediator.TruckMediator;

public class BrakeLightOn implements ICommand{
    TruckMediator truckMediator;

    BrakeLightOn(TruckMediator truckMediator) {
        this.truckMediator = truckMediator;
    }
    @Override
    public void execute() {

    }

    @Override
    public void execute(int nr1) {

    }

    @Override
    public void execute(int nr1, int nr2) {

    }
}
