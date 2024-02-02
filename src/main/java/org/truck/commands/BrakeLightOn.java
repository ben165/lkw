package org.truck.commands;

import org.truck.vehicle.mediator.TruckMediator;

public class BrakeLightOn implements ICommand{
    private final TruckMediator truckMediator;

    public BrakeLightOn(TruckMediator truckMediator) {
        this.truckMediator = truckMediator;
    }

    @Override
    public void execute(int... numbers) {
        this.truckMediator.brakeLights(true);
    }
}
