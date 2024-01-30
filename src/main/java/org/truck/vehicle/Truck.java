package org.truck.vehicle;

import org.truck.parts.Blinker;
import org.truck.parts.Brakelight;
import org.truck.parts.axle.FixedAxle;
import org.truck.parts.axle.WheelAxle;
import org.truck.truckParts.*;

public class Truck {
    private TruckChassis truckChassis;
    private Cabin cabin;
    private Motor motor;
    private WheelAxle frontAxle;
    private FixedAxle[] backAxles;
    private Headlight[] headlights;
    private Mirror[] mirrors;
    private Blinker[] leftBlinkers;
    private Blinker[] rightBlinkers;
    private Brakelight[] brakelights;


    private Truck(Builder builder) {
        
    }

    public static class Builder {
        private TruckChassis truckChassis;
        private Cabin cabin;
        private Motor motor;
        private WheelAxle frontAxle;
        private FixedAxle[] backAxles;
        private Headlight[] headlights;
        private Mirror[] mirrors;
        private Blinker[] leftBlinkers;
        private Blinker[] rightBlinkers;
        private Brakelight[] brakeLights;


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

        public Builder frontAxle() {
            this.frontAxle = new WheelAxle();
            return this;
        }

        public Builder backAxles() {
            this.backAxles = new FixedAxle[2];
            this.backAxles[0] = new FixedAxle();
            this.backAxles[1] = new FixedAxle();
            return this;
        }

        public Builder headlights() {
            this.headlights = new Headlight[2];
            this.headlights[0] = new Headlight();
            this.headlights[1] = new Headlight();
            return this;
        }

        public Builder mirrors() {
            this.mirrors = new Mirror[2];
            this.mirrors[0] = new Mirror();
            this.mirrors[1] = new Mirror();
            return this;
        }

        public Builder leftBlinkers() {
            this.leftBlinkers = new Blinker[2];
            this.leftBlinkers[0] = new Blinker();
            this.leftBlinkers[1] = new Blinker();
            return this;
        }

        public Builder rightBlinkers() {
            this.rightBlinkers = new Blinker[2];
            this.rightBlinkers[0] = new Blinker();
            this.rightBlinkers[1] = new Blinker();
            return this;
        }

        public Builder brakeLights() {
            this.brakeLights = new Brakelight[2];
            this.brakeLights[0] = new Brakelight();
            this.brakeLights[1] = new Brakelight();
            return this;
        }

        public Truck build() {
            return new Truck(this);
        }
    }



}
