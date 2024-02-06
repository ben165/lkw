package org.truck.commands;

import org.truck.parts.Indicators;
import org.truck.parts.axle.TurningAxle;
import org.truck.truckParts.Engine;
import org.truck.truckParts.mediator.TruckMediator;
import org.truck.vehicle.Truck;

public class MoveStraight implements ICommand{
    TurningAxle turningAxle;
    Engine engine;
    TruckMediator truckMediator;
    public MoveStraight(Truck truck) {
        turningAxle = truck.getFrontAxle();
        engine = truck.getEngine();
        truckMediator = truck.truckMediator;
    }
    @Override
    public void execute(int... numbers) {
        turningAxle.turnLeft(0);
        // safe speed
        if (numbers[0] > 75) {
            numbers[0] = 75;
        }
        engine.setEngineSpeed(numbers[0]);
        truckMediator.indicateOff();
    }
}
