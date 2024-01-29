package org.truck.vehicle;

import org.truck.parts.Blinker;
import org.truck.parts.Brakelight;
import org.truck.parts.axle.AbstractAxle;
import org.truck.parts.axle.FixedAxle;
import org.truck.parts.axle.WheelAxle;
import org.truck.truckParts.*;

public class Truck {

    public static class Builder {
        private TruckChassis chassis;
        private Cabin cabin;
        private Motor motor;
        private WheelAxle frontAxle;
        private FixedAxle[] backAxles;
        private Headlight[] headlights;
        private Mirror[] mirrors;
        private Blinker[] leftBlinkers;
        private Blinker[] rightBlinkers;
        private Brakelight[] brakelights;
    }


}
