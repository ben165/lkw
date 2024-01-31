package org.truck.parts.axle;

public class TurningAxle extends AbstractAxle{
    public TurningAxle() {
        super();
    }

    @Override
    void brake(int percentage) {
        super.brakes[0].setPercentage(percentage);
        super.brakes[1].setPercentage(percentage);
    }
}
