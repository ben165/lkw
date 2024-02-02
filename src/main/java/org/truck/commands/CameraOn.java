package org.truck.commands;

import org.truck.vehicle.mediator.TruckMediator;

public class CameraOn implements ICommand{
    private final TruckMediator truckMediator;

    public CameraOn(TruckMediator truckMediator) {
        this.truckMediator = truckMediator;
    }


    @Override
    public void execute(int... numbers) {
        this.truckMediator.camera(true);
    }
}
