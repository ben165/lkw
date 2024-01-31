package org.truck.parts;

public class Blinkers {
    boolean leftBlinker = false;
    boolean rightBliner = false;

    public boolean isLeftBlinker() {
        return leftBlinker;
    }

    public void setLeftBlinker(boolean leftBlinker) {
        this.rightBliner = false;
        this.leftBlinker = true;
    }

    public boolean isRightBliner() {
        return rightBliner;
    }

    public void setRightBliner(boolean rightBliner) {
        this.leftBlinker = false;
        this.rightBliner = true;
    }
}
