package org.truck.trailerParts.mediator;

import org.truck.eventBus.Event;
import org.truck.eventBus.EventMsg;
import org.truck.parts.Brakelight;
import org.truck.parts.Indicators;
import org.truck.parts.axle.FixedAxle;

public class TrailerMediator extends Event implements ITrailerMediator {
    Brakelight[] brakelights;
    Indicators tailIndicators;
    FixedAxle[] backAxles;

    public void setBrakelights(Brakelight[] brakelights) {
        this.brakelights = brakelights;
    }

    public void setTailIndicators(Indicators tailIndicators) {
        this.tailIndicators = tailIndicators;
    }

    public void setBackAxles(FixedAxle[] backAxles) {
        this.backAxles = backAxles;
    }

    @Override
    public void indicateOff() {
        tailIndicators.setRightBlinker(false);
        tailIndicators.setLeftBlinker(false);
        System.out.println("trailer off");
    }

    @Override
    public void indicateRight() {
        tailIndicators.setRightBlinker(true);
        tailIndicators.setLeftBlinker(false);
        System.out.println("trailer right");
    }

    @Override
    public void indicateLeft() {
        tailIndicators.setLeftBlinker(true);
        tailIndicators.setRightBlinker(false);
        System.out.println("trailer left");
    }

    @Override
    public void brakeLights(boolean status) {
        brakelights[0].setStatus(status);
        brakelights[1].setStatus(status);
        System.out.println("trailer brake");
    }

    @Override
    public void brake(int percentage) {
        for (int i = 0; i < backAxles.length; i++) {
            backAxles[i].setBrake(percentage);
            System.out.println("brake trailer");
        }
    }

    @Override
    public void trigger(EventMsg msg) {
        switch (msg.cmd) {
            case 0 -> this.brakeLights(false);
            case 1 -> this.brakeLights(true);
            case 2 -> this.indicateOff();
            case 3 -> this.indicateLeft();
            case 4 -> this.indicateRight();
            case 5 -> this.brake(msg.par);
        }
    }
}
