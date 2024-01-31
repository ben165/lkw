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

    abstract void brake(int percentage);
}
