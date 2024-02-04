package org.truck.commands;

import org.truck.truckParts.mediator.TruckMediator;

public class LidarOff implements ICommand{
    private final TruckMediator truckMediator;

    public LidarOff(TruckMediator truckMediator) {
        this.truckMediator = truckMediator;
    }

    @Override
    public void execute(int... numbers) {
        this.truckMediator.lidar(false);
    }
}
