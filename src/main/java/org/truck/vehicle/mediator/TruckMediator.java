package org.truck.vehicle.mediator;

import org.truck.parts.Brakelight;
import org.truck.parts.Indicators;
import org.truck.parts.axle.FixedAxle;
import org.truck.parts.axle.TurningAxle;
import org.truck.truckParts.Headlight;
import org.truck.truckParts.Mirror;

public class TruckMediator implements ITruckMediator{

    Headlight[] headlights;
    Brakelight[] brakelights;
    Indicators frontIndicators;
    Indicators tailIndicators;
    Mirror[] mirrors;
    TurningAxle frontAxle;
    FixedAxle[] backAxles;

    public void setHeadlight(Headlight[] headlights) {
        this.headlights = headlights;
    }

    public void setBrakelight(Brakelight[] brakelights) {
        this.brakelights = brakelights;
    }

    public void setFrontIndicators(Indicators frontIndicators) {
        this.frontIndicators = frontIndicators;
    }

    public void setTailIndicators(Indicators tailIndicators) {
        this.tailIndicators = tailIndicators;
    }

    public void setMirrors(Mirror[] mirrors) {
        this.mirrors = mirrors;
    }

    public void setFrontAxle(TurningAxle frontAxle) {
        this.frontAxle = frontAxle;
    }

    public void setBackAxles(FixedAxle[] backAxles) {
        this.backAxles = backAxles;
    }

    @Override
    public void indicateRight() {
        frontIndicators.setLeftBlinker(true);
        frontIndicators.setRightBlinker(false);

        tailIndicators.setLeftBlinker(true);
        tailIndicators.setLeftBlinker(false);
    }

    @Override
    public void indicateLeft() {
        frontIndicators.setLeftBlinker(false);
        frontIndicators.setRightBlinker(true);

        tailIndicators.setLeftBlinker(false);
        tailIndicators.setLeftBlinker(true);
    }

    @Override
    public void brakeLights(boolean status) {
        brakelights[0].setStatus(status);
        brakelights[1].setStatus(status);
    }

    @Override
    public void brake(int percentage) {
        frontAxle.setBrake(percentage);
        for (int i=0; i<backAxles.length; i++) {
            backAxles[i].setBrake(percentage);
        }
    }

    @Override
    public void headLights(boolean status) {
        headlights[0].setStatus(status);
        headlights[1].setStatus(status);
    }

    @Override
    public void camera(boolean status) {
        mirrors[0].setCameraStatus(status);
        mirrors[1].setCameraStatus(status);
    }

    @Override
    public void lidar(boolean status) {
        mirrors[0].setLidarStatus(status);
        mirrors[1].setLidarStatus(status);
    }
}