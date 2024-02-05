package org.truck.commands;

import org.truck.parts.axle.TurningAxle;
import org.truck.vehicle.Truck;

public class TurnRight implements ICommand{
    TurningAxle turningAxle;
    public TurnRight(Truck truck) {
        turningAxle = truck.getFrontAxle();
    }
    @Override
    public void execute(int... numbers) {
        turningAxle.turnRight(numbers[0]);
    }
}
