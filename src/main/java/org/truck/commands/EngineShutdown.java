package org.truck.commands;

import org.truck.truckParts.Engine;
import org.truck.vehicle.Truck;

public class EngineShutdown implements ICommand {
    private Engine engine;

    public EngineShutdown(Truck truck) {
        engine = truck.getEngine();
    }

    @Override
    public void execute(int... numbers) {
        engine.setEngineOn(false);
    }
}
