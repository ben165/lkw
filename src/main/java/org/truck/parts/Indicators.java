package org.truck.parts;

public class Indicators {
    boolean leftBlinker = false;
    boolean rightBlinker = false;

    public boolean isLeftIndicator() {
        return leftBlinker;
    }

    public boolean isRightIndicator() {
        return rightBlinker;
    }

    public void setLeftIndicator(boolean status) {
        this.leftBlinker = status;
        //System.out.println("Left indicator "+ this.hashCode() +": " + this.leftBlinker);
    }

    public void setRightIndicator(boolean status) {
        this.rightBlinker = status;
        //System.out.println("Right indicator " + this.hashCode() + ": " + this.rightBlinker);
    }
}
