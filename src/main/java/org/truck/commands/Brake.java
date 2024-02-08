package org.truck.commands;

import org.truck.truckParts.mediator.TruckMediator;

public class Brake implements ICommand {

    private final TruckMediator truckMediator;

    public Brake(TruckMediator truckMediator) {
        this.truckMediator = truckMediator;
    }

    @Override
    public void execute(int... numbers) {
        this.truckMediator.brake(numbers[0]);
    }
}
