package org.truck.truckParts.battery;

public abstract class ACell {
    public abstract void add(ACell cell);

    public abstract ACell getChild(int i);

    public abstract int getStatus();

    public abstract void setStatus(int status);
}
