package org.truck.vehicle;

import org.truck.CentralUnit;
import org.truck.observer.TrailerDetector;
import org.truck.parts.Indicators;
import org.truck.parts.Brakelight;
import org.truck.parts.axle.FixedAxle;
import org.truck.parts.axle.TurningAxle;
import org.truck.truckParts.*;
import org.truck.truckParts.battery.Battery;
import org.truck.truckParts.mediator.TruckMediator;

import static org.truck.helper.PositionEnum.*;

import java.util.Arrays;

public class Truck {
    public final TruckMediator truckMediator;
    private Trailer trailer;
    private final int amountBackAxles;
    private final TruckChassis truckChassis;
    private final Cabin cabin;
    private final Motor motor;
    private final Battery battery;
    private final TurningAxle frontAxle;
    private final FixedAxle[] backAxles;
    private final Headlight[] headLights;
    private final Mirror[] mirrors;
    private final Indicators frontIndicators;
    private final Indicators tailIndicators;
    private final Brakelight[] brakelights;
    public final Hitch hitch;
    private CentralUnit centralUnit;


    private Truck(Builder builder) {
        this.truckMediator = builder.truckMediator;
        this.amountBackAxles = builder.amountBackAxles;
        this.truckChassis = builder.truckChassis;
        this.cabin = builder.cabin;
        this.motor = builder.motor;
        this.battery = builder.battery;
        this.frontAxle = builder.frontAxle;
        this.backAxles = builder.backAxles;
        this.headLights = builder.headLights;
        this.mirrors = builder.mirrors;
        this.frontIndicators = builder.frontIndicators;
        this.tailIndicators = builder.tailIndicators;
        this.brakelights = builder.brakelights;
        this.hitch = builder.hitch;
    }

    public static class Builder {
        private TruckMediator truckMediator;
        private int amountBackAxles;
        private TruckChassis truckChassis;
        private Cabin cabin;
        private Motor motor;
        private Battery battery;
        private TurningAxle frontAxle;
        private FixedAxle[] backAxles;
        private Headlight[] headLights;
        private Mirror[] mirrors;
        private Indicators frontIndicators;
        private Indicators tailIndicators;
        private Brakelight[] brakelights;
        private Hitch hitch;

        public Builder truckMediator() {
            this.truckMediator = new TruckMediator();
            return this;
        }
        public Builder truckChassis() {
            this.truckChassis = new TruckChassis();
            return this;
        }

        public Builder cabin() {
            this.cabin = new Cabin();
            return this;
        }

        public Builder motor() {
            this.motor = new Motor();
            return this;
        }

        public Builder battery() {
            this.battery = new Battery();
            return this;
        }

        public Builder frontAxle() {
            this.frontAxle = new TurningAxle();
            this.truckMediator.setFrontAxle(this.frontAxle);
            return this;
        }

        public Builder backAxles(int axles) {
            this.amountBackAxles = axles;
            this.backAxles = new FixedAxle[axles];
            for (int i=0; i<axles; i++) {
                backAxles[i] = new FixedAxle();
            }
            this.truckMediator.setBackAxles(this.backAxles);
            return this;
        }

        public Builder headlights() {
            this.headLights = new Headlight[2];
            this.headLights[LEFT.ordinal()] = new Headlight();
            this.headLights[RIGHT.ordinal()] = new Headlight();
            this.truckMediator.setHeadlight(this.headLights);
            return this;
        }

        public Builder mirrors() {
            this.mirrors = new Mirror[2];
            this.mirrors[LEFT.ordinal()] = new Mirror();
            this.mirrors[RIGHT.ordinal()] = new Mirror();
            this.truckMediator.setMirrors(this.mirrors);
            return this;
        }

        public Builder frontBlinkers() {
            this.frontIndicators = new Indicators();
            this.truckMediator.setFrontIndicators(this.frontIndicators);
            return this;
        }

        public Builder tailBlinkers() {
            this.tailIndicators = new Indicators();
            this.truckMediator.setTailIndicators(this.tailIndicators);
            return this;
        }

        public Builder brakeLights() {
            this.brakelights = new Brakelight[2];
            this.brakelights[LEFT.ordinal()] = new Brakelight();
            this.brakelights[RIGHT.ordinal()] = new Brakelight();
            this.truckMediator.setBrakelight(this.brakelights);
            return this;
        }

        public Builder hitch() {
            this.hitch = new Hitch();
            return this;
        }

        public Truck build() {
            return new Truck(this);
        }
    }

    public void setCentralUnit(CentralUnit centralUnit) {
        this.centralUnit = centralUnit;
    }

    public void connectTrailerToHitch(Trailer trailer) {
        this.trailer = trailer;
        hitch.setCentralUnit(centralUnit);
        hitch.setConnected(true);

        // Needed for loading sensors
        trailer.loadingArea.setCentralUnit(centralUnit);
    }




    public boolean checkTruckBuilder() {

        // Chassis
        if (this.truckChassis == null) {
            return false;
        }
        // Motor
        if (this.motor == null) {
            return false;
        }
        // Battery
        if (this.battery == null) {
            return false;
        }
        // frontAxle
        if (this.frontAxle == null) {
            return false;
        }
        // backAxle(s)
        for (int i=0; i < backAxles.length; i++) {
            if (backAxles[i] == null) {
                return false;
            }
        }
        // Indicators front
        if (this.frontIndicators == null) {
            return false;
        }
        // Indicators tail
        if (this.tailIndicators == null) {
            return false;
        }
        // BrakeLights
        if (this.brakelights[LEFT.ordinal()] == null || this.brakelights[RIGHT.ordinal()] == null) {
            return false;
        }
        // Cabin
        if (this.cabin == null) {
            return false;
        }
        // Mirrors
        if (this.mirrors[LEFT.ordinal()] == null || this.mirrors[RIGHT.ordinal()] == null) {
            return false;
        }
        // Cameras
        if (this.mirrors[LEFT.ordinal()].getCamera() == null || this.mirrors[RIGHT.ordinal()].getCamera() == null) {
            return false;
        }
        // Lidars
        if (this.mirrors[LEFT.ordinal()].getLidar() == null || this.mirrors[RIGHT.ordinal()].getLidar() == null) {
            return false;
        }
        // Hitch
        if (this.hitch == null) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return "Truck{" +
                "truckMediator" + truckMediator + "\n" +
                "amountBackAxles=" + amountBackAxles + "\n" +
                "truckChassis=" + truckChassis + "\n" +
                ", cabin=" + cabin + "\n" +
                ", motor=" + motor + "\n" +
                ", frontAxle=" + frontAxle + "\n" +
                ", backAxles=" + Arrays.toString(backAxles) + "\n" +
                ", headLights=" + Arrays.toString(headLights) + "\n" +
                ", mirrors=" + Arrays.toString(mirrors) + "\n" +
                ", frontIndicators=" + frontIndicators + "\n" +
                ", tailIndicators=" + tailIndicators + "\n" +
                ", brakeLights=" + Arrays.toString(brakelights) + "\n" +
                '}';
    }
}
