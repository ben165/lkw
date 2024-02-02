package org.truck.parts.axle;

public class TurningAxle extends AbstractAxle{

    public TurningAxle() {
        super();
    }

    @Override
    public void turnRight(int angle) {
        //not possible
    }

    @Override
    public void turnLeft(int angle) {
        //not possible
    }

    @Override
    public int getAngle() {
        return 0;
    }

}
