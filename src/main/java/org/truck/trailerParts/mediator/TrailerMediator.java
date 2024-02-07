package org.truck.trailerParts.mediator;

import org.truck.eventBus.Event;
import org.truck.parts.Brakelight;
import org.truck.parts.Indicators;
import org.truck.parts.axle.FixedAxle;

public class TrailerMediator extends Event implements ITrailerMediator{
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
    }

    @Override
    public void indicateRight() {
        tailIndicators.setRightBlinker(true);
        tailIndicators.setLeftBlinker(false);
    }

    @Override
    public void indicateLeft() {
        tailIndicators.setLeftBlinker(true);
        tailIndicators.setRightBlinker(false);
    }

    @Override
    public void brakeLights(boolean status) {
        brakelights[0].setStatus(status);
        brakelights[1].setStatus(status);
    }

    @Override
    public void brake(int percentage) {
        for (int i=0; i<backAxles.length; i++) {
            backAxles[i].setBrake(percentage);
        }
    }

    @Override
    public void trigger(int code) {
        if (code == 0) {
            this.brakeLights(false);
        }
    }
}
