package org.truck.parts.axle;

import org.truck.parts.Brake;
import org.truck.parts.Wheel;

public class WheelAxle extends AbstractAxle{
    public WheelAxle() {
        super.leftBrake = new Brake();
        super.rightBrake = new Brake();
        super.leftWheel = new Wheel();
        super.rightWheel = new Wheel();
    }
}
