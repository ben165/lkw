package org.truck.truckParts;

import org.truck.visitor.IVisitor;
import org.truck.visitor.Visitor;

public class Lidar implements IVisitor {
    boolean isOn = false;
    int side;
    public Lidar(int side) {
        this.side = side;
    }

    public boolean getIsOn() {
        return isOn;
    }

    public void setIsOn(boolean status) {
        this.isOn = status;
    }

    public int getSide() {
        return side;
    }

    @Override
    public void accept(Visitor visitor) {

    }
}
