package org.truck.parts.axle;

public class FixedAxle extends AbstractAxle{
    public FixedAxle() {
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
