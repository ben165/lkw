package org.truck.parts.axle;

public abstract class AbstractAxle {
    Brake[] brakes = new Brake[2];
    Wheel[] wheels = new Wheel[2];

    AbstractAxle() {
        wheels[0] = new Wheel();
        brakes[0] = new Brake();
        wheels[1] = new Wheel();
        brakes[1] = new Brake();
    }

    public void setBrake(int percentage) {
        brakes[0].setPercentage(percentage);
        brakes[1].setPercentage(percentage);
    }
    public int getBrake() {
        return brakes[0].getPercentage();
    }

    public abstract void turnRight(int angle);
    public abstract void turnLeft(int angle);
    public abstract int getAngle();
}
