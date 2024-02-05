package org.truck.commands;

import org.truck.truckParts.Motor;
import org.truck.vehicle.Truck;

public class EngineStart implements ICommand{
    Motor motor;
    public EngineStart(Truck truck) {
        motor = truck.getMotor();
    }
    @Override
    public void execute(int... numbers) {
        motor.setStatus(false);
    }
}
