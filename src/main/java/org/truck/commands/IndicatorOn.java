package org.truck.commands;

import org.truck.vehicle.mediator.TruckMediator;

public class IndicatorOn implements ICommand{

    private final TruckMediator truckMediator;

    public IndicatorOn(TruckMediator truckMediator) {
        this.truckMediator = truckMediator;
    }


    @Override
    public void execute(int... numbers) {
        if (numbers[0] == 0) {
            truckMediator.indicateLeft();
        } else if (numbers[0] == 1) {
            truckMediator.indicateRight();
        }
    }
}
