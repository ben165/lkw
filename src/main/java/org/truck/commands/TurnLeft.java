package org.truck.commands;

import org.truck.parts.axle.TurningAxle;
import org.truck.truckParts.Engine;
import org.truck.vehicle.Truck;

public class TurnLeft implements ICommand{
    TurningAxle turningAxle;
    public TurnLeft(Truck truck) {
        turningAxle = truck.getFrontAxle();
    }
    @Override
    public void execute(int... numbers) {
        turningAxle.turnLeft(numbers[0] + 90);
    }

}
