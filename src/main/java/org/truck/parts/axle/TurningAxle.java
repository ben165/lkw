package org.truck.parts.axle;

public class TurningAxle extends AbstractAxle{
    private int angle;

    public TurningAxle() {
        super();
    }

    @Override
    public void turnRight(int angle) {
        this.angle = angle;
    }

    @Override
    public void turnLeft(int angle) {
        this.angle = angle;
    }

    @Override
    public int getAngle() {
        return this.angle;
    }

}
