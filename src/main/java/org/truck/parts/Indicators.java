package org.truck.parts;

public class Indicators {
    boolean leftBlinker = false;
    boolean rightBlinker = false;

    public boolean isLeftBlinker() {
        return leftBlinker;
    }

    public boolean isRightBlinker() {
        return rightBlinker;
    }

    public void setLeftBlinker(boolean status) {
        this.leftBlinker = status;
        //System.out.println("Left indicator "+ this.hashCode() +": " + this.leftBlinker);
    }

    public void setRightBlinker(boolean status) {
        this.rightBlinker = status;
        //System.out.println("Right indicator " + this.hashCode() + ": " + this.rightBlinker);
    }
}
