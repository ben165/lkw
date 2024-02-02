package org.truck.truckParts.battery;

public abstract class Cell {
    int status; // 1 or 0 for loaded or empty
    public abstract void add(Cell cell);
    public abstract Cell getChild(int i);
    public void unload() {
        this.status = 0;
    }
    public void load() {
        this.status = 1;
    }
}
