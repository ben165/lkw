package org.truck.parts;

public class Indicators {
    boolean leftBlinker = false;
    boolean rightBlinker = false;

    public boolean isLeftBlinker() {
        return leftBlinker;
    }

    public void setLeftBlinker(boolean leftBlinker) {
        this.leftBlinker = true;
    }

    public boolean isRightBlinker() {
        return rightBlinker;
    }

    public void setRightBlinker(boolean rightBlinker) {
        this.rightBlinker = true;
    }
}
