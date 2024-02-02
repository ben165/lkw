package org.truck;

import org.truck.commands.*;
import org.truck.vehicle.Truck;
import org.truck.vehicle.mediator.TruckMediator;

public class CentralUnit {
    Truck truck;
    Control control = new Control();
    TruckMediator mediator;
    ICommand headlightsOn;
    ICommand headlightsOff;
    ICommand indicatorOn;
    ICommand indicatorOff;
    public CentralUnit(Truck truck) {
        this.truck = truck;
        this.mediator = truck.truckMediator;

        headlightsOn = new HeadlightOn(this.mediator);
        headlightsOff = new HeadlightOff(this.mediator);

        indicatorOn = new IndicatorOn(this.mediator);
        indicatorOff = new IndicatorOff(this.mediator);
    }

    public void indicatorOn(int side) {
        control.setCommand(indicatorOn);
        control.action(side);
    }

    public void indicatorOff() {
        control.setCommand(indicatorOff);
        control.action();
    }

    public void headlightsOn() {
        control.setCommand(headlightsOn);
        control.action();
    }

    public void headlightsOff() {
        control.setCommand(headlightsOff);
        control.action();
    }
}
