package org.truck.commands;

import org.truck.truckParts.mediator.TruckMediator;

public class IndicatorOff implements ICommand {

    private final TruckMediator truckMediator;

    public IndicatorOff(TruckMediator truckMediator) {
        this.truckMediator = truckMediator;
    }

    @Override
    public void execute(int... numbers) {
        truckMediator.indicateOff();
    }
}
