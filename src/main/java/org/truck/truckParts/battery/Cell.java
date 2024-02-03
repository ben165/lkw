package org.truck.truckParts.battery;

public class Cell extends ACell{
    private int status = 0;
    @Override
    public void add(ACell cell) {}

    @Override
    public ACell getChild(int i) {
        return null;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
