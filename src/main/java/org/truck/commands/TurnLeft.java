package org.truck.commands;

import org.truck.parts.axle.TurningAxle;
import org.truck.truckParts.Engine;
import org.truck.truckParts.mediator.TruckMediator;
import org.truck.vehicle.Truck;

public class TurnLeft implements ICommand {
    TurningAxle turningAxle;
    Engine engine;
    TruckMediator truckMediator;

    public TurnLeft(Truck truck) {
        turningAxle = truck.getFrontAxle();
        engine = truck.getEngine();
        truckMediator = truck.truckMediator;
    }

    @Override
    public void execute(int... numbers) {
        turningAxle.turnLeft(numbers[0] + 90);
        // safe speed
        if (numbers[1] > 50) {
            numbers[1] = 50;
        }
        engine.setEngineSpeed(numbers[1]);
        truckMediator.indicateLeft();
    }

}
