package org.truck.commands;

import org.truck.vehicle.mediator.TruckMediator;

public class LidarOn implements ICommand{
    private final TruckMediator truckMediator;

    public LidarOn(TruckMediator truckMediator) {
        this.truckMediator = truckMediator;
    }

    @Override
    public void execute(int... numbers) {
        this.truckMediator.camera(true);
    }
}
