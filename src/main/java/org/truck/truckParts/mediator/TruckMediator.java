package org.truck.truckParts.mediator;

import org.truck.eventBus.EventMsg;
import org.truck.eventBus.Publisher;
import org.truck.parts.Brakelight;
import org.truck.parts.Indicators;
import org.truck.parts.axle.FixedAxle;
import org.truck.parts.axle.TurningAxle;
import org.truck.truckParts.Headlight;
import org.truck.truckParts.Mirror;

public class TruckMediator implements ITruckMediator {

    Headlight[] headlights;
    Brakelight[] brakelights;
    Indicators frontIndicators;
    Indicators tailIndicators;
    Mirror[] mirrors;
    TurningAxle frontAxle;
    FixedAxle[] backAxles;
    Publisher publisher;
    EventMsg eventMsg = new EventMsg();

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
        frontIndicators.setRightIndicator(false);
        tailIndicators.setRightIndicator(false);

        frontIndicators.setLeftIndicator(false);
        tailIndicators.setLeftIndicator(false);

        if (publisher != null) {
            eventMsg.cmd = 2;
            publisher.send(eventMsg);
        }
    }

    @Override
    public void indicateRight() {
        frontIndicators.setRightIndicator(true);
        tailIndicators.setRightIndicator(true);

        frontIndicators.setLeftIndicator(false);
        tailIndicators.setLeftIndicator(false);

        if (publisher != null) {
            eventMsg.cmd = 4;
            publisher.send(eventMsg);
        }
    }

    @Override
    public void indicateLeft() {
        frontIndicators.setLeftIndicator(true);
        tailIndicators.setLeftIndicator(true);

        frontIndicators.setRightIndicator(false);
        tailIndicators.setRightIndicator(false);

        if (publisher != null) {
            eventMsg.cmd = 3;
            publisher.send(eventMsg);
        }
    }

    @Override
    public void brakeLights(boolean status) {
        brakelights[0].setStatus(status);
        brakelights[1].setStatus(status);

        if (publisher != null) {
            if (status) {
                eventMsg.cmd = 1;
            } else {
                eventMsg.cmd = 0;
            }

            publisher.send(eventMsg);
        }
    }

    @Override
    public void brake(int percentage) {
        frontAxle.setBrake(percentage);
        for (int i = 0; i < backAxles.length; i++) {
            backAxles[i].setBrake(percentage);
        }

        if (publisher != null) {
            eventMsg.cmd = 5;
            eventMsg.par = percentage;
            publisher.send(eventMsg);
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

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
