package org.truck.commands;

import org.truck.truckParts.mediator.TruckMediator;

public class CameraOff implements ICommand {
    private final TruckMediator truckMediator;

    public CameraOff(TruckMediator truckMediator) {
        this.truckMediator = truckMediator;
    }

    @Override
    public void execute(int... numbers) {
        this.truckMediator.camera(false);
    }
}
