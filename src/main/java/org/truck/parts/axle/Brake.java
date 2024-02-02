package org.truck.parts.axle;

public class Brake {
    private int percentage = 0;

    public int getPercentage() {
        return this.percentage;
    }

    public void setPercentage(int percentage) {
        //System.out.println("Brake changed to: " + percentage);
        this.percentage = percentage;
    }
}
