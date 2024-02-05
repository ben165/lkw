package org.truck.commands;

import org.truck.truckParts.Motor;
import org.truck.vehicle.Truck;

public class EngineShutdown implements ICommand{
    Motor motor;
    public EngineShutdown(Truck truck) {
        motor = truck.getMotor();
    }
    @Override
    public void execute(int... numbers) {
        motor.setStatus(false);
    }
}
