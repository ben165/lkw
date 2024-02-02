package org.truck.commands;

import org.truck.vehicle.mediator.TruckMediator;

public class Brake implements ICommand{

    TruckMediator truckMediator;

    Brake(TruckMediator truckMediator) {
        this.truckMediator = truckMediator;
    }
    @Override
    public void execute() {
        //not implemented
    }

    @Override
    public void execute(int percentage) {
        this.truckMediator.brake(percentage);
    }

    @Override
    public void execute(int nr1, int nr2) {
        //not implemented
    }
}
