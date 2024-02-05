package org.truck.commands;

import org.truck.parts.axle.TurningAxle;
import org.truck.vehicle.Truck;

public class MoveStraight implements ICommand{
    TurningAxle turningAxle;
    public MoveStraight(Truck truck) {
        turningAxle = truck.getFrontAxle();
    }
    @Override
    public void execute(int... numbers) {
        turningAxle.turnLeft(0);
    }
}
