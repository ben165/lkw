package org.truck.truckParts.battery;

public abstract class Cell {
    protected int status = 0;
    public abstract void add(Cell cell);
    public abstract Cell getChild(int i);
    public void unload() {
        this.status = 0;
    }
    public void load() {
        this.status = 1;
    }
}
