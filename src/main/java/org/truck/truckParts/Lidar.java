package org.truck.truckParts;

import org.truck.Config;
import org.truck.helper.Rand;
import org.truck.visitor.IVisitor;
import org.truck.visitor.Visitor;
public class Lidar implements IVisitor {
    boolean isOn = false;
    int side;
    boolean isDamaged;

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

    public boolean isDamaged() {
        return isDamaged;
    }

    public void setDamaged(boolean damaged) {
        isDamaged = damaged;
    }

    @Override
    public void accept(Visitor visitor) {
        if (Rand.rand() <= Config.PERCENTAGE) {
            System.out.println("Error detected");
            visitor.addPart(this);
            visitor.addCategory(Rand.randError());
        };
    }
}
