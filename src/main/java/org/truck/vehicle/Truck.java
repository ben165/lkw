package org.truck.vehicle;

import org.truck.parts.Indicators;
import org.truck.parts.Brakelight;
import org.truck.parts.axle.FixedAxle;
import org.truck.parts.axle.TurningAxle;
import org.truck.trailerParts.ConnectorClutch;
import org.truck.truckParts.*;
import org.truck.vehicle.mediator.TruckMediator;

import java.util.Arrays;

public class Truck {
    public final TruckMediator truckMediator;
    private final int amountBackAxles;
    private final TruckChassis truckChassis;
    private final ConnectorClutch connectorClutch;
    private final Cabin cabin;
    private final Motor motor;
    private final TurningAxle frontAxle;
    private final FixedAxle[] backAxles;
    private final Headlight[] headLights;
    private final Mirror[] mirrors;
    private final Indicators frontIndicators;
    private final Indicators tailIndicators;
    private final Brakelight[] brakelights;


    private Truck(Builder builder) {
        this.truckMediator = builder.truckMediator;
        this.amountBackAxles = builder.amountBackAxles;
        this.truckChassis = builder.truckChassis;
        this.connectorClutch = builder.connectorClutch;
        this.cabin = builder.cabin;
        this.motor = builder.motor;
        this.frontAxle = builder.frontAxle;
        this.backAxles = builder.backAxles;
        this.headLights = builder.headLights;
        this.mirrors = builder.mirrors;
        this.frontIndicators = builder.frontIndicators;
        this.tailIndicators = builder.tailIndicators;
        this.brakelights = builder.brakelights;
    }

    public static class Builder {
        TruckMediator truckMediator;
        private int amountBackAxles;
        private TruckChassis truckChassis;
        private ConnectorClutch connectorClutch;
        private Cabin cabin;
        private Motor motor;
        private TurningAxle frontAxle;
        private FixedAxle[] backAxles;
        private Headlight[] headLights;
        private Mirror[] mirrors;
        private Indicators frontIndicators;
        private Indicators tailIndicators;
        private Brakelight[] brakelights;

        public Builder truckMediator() {
            this.truckMediator = new TruckMediator();
            return this;
        }
        public Builder truckChassis() {
            this.truckChassis = new TruckChassis();
            return this;
        }

        public Builder connectorClutch() {
            this.connectorClutch = new ConnectorClutch();
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
            this.headLights[0] = new Headlight();
            this.headLights[1] = new Headlight();
            this.truckMediator.setHeadlight(this.headLights);
            return this;
        }

        public Builder mirrors() {
            this.mirrors = new Mirror[2];
            this.mirrors[0] = new Mirror();
            this.mirrors[1] = new Mirror();
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
            this.brakelights[0] = new Brakelight();
            this.brakelights[1] = new Brakelight();
            this.truckMediator.setBrakelight(this.brakelights);
            return this;
        }

        public Truck build() {
            return new Truck(this);
        }
    }


    @Override
    public String toString() {
        return "Truck{" +
                "truckMediator" + truckMediator + "\n" +
                "amountBackAxles=" + amountBackAxles + "\n" +
                "truckChassis=" + truckChassis + "\n" +
                ", connectorClutch=" + connectorClutch + "\n" +
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
