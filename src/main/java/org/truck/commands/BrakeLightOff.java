package org.truck.commands;

import org.truck.vehicle.mediator.TruckMediator;

public class BrakeLightOff implements ICommand{
    private final TruckMediator truckMediator;

    public BrakeLightOff(TruckMediator truckMediator) {
        this.truckMediator = truckMediator;
    }

    @Override
    public void execute(int... numbers) {
        this.truckMediator.brakeLights(false);
    }
}
