package org.truck.commands;

import org.truck.truckParts.Engine;
import org.truck.vehicle.Truck;

public class EngineStart implements ICommand {
    Engine engine;

    public EngineStart(Truck truck) {
        engine = truck.getEngine();
    }

    @Override
    public void execute(int... numbers) {
        engine.setEngineOn(true);
    }
}
