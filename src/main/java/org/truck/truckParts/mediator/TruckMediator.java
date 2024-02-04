package org.truck.truckParts.mediator;

import org.truck.parts.Brakelight;
import org.truck.parts.Indicators;
import org.truck.parts.axle.FixedAxle;
import org.truck.parts.axle.TurningAxle;
import org.truck.truckParts.Headlight;
import org.truck.truckParts.Mirror;

import java.util.Arrays;

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

    public void indicateOff() {
        frontIndicators.setRightBlinker(false);
        tailIndicators.setRightBlinker(false);

        frontIndicators.setLeftBlinker(false);
        tailIndicators.setLeftBlinker(false);
    }

    @Override
    public void indicateRight() {
        frontIndicators.setRightBlinker(true);
        tailIndicators.setRightBlinker(true);

        frontIndicators.setLeftBlinker(false);
        tailIndicators.setLeftBlinker(false);
    }

    @Override
    public void indicateLeft() {
        frontIndicators.setLeftBlinker(true);
        tailIndicators.setLeftBlinker(true);

        frontIndicators.setRightBlinker(false);
        tailIndicators.setRightBlinker(false);
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

    @Override
    public String toString() {
        return "TruckMediator{" +"\n" +
                "headlights=" + Arrays.toString(headlights) + "\n" +
                ", brakelights=" + Arrays.toString(brakelights) +"\n" +
                ", frontIndicators=" + frontIndicators +"\n" +
                ", tailIndicators=" + tailIndicators +"\n" +
                ", mirrors=" + Arrays.toString(mirrors) +"\n" +
                ", frontAxle=" + frontAxle +"\n" +
                ", backAxles=" + Arrays.toString(backAxles) +"\n" +
                '}';
    }
}
