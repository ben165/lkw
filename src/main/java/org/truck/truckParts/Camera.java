package org.truck.truckParts;

import org.truck.Config;
import org.truck.helper.Rand;
import org.truck.visitor.IVisitor;
import org.truck.visitor.Visitor;

public class Camera implements IVisitor {
    boolean isOn = false;
    int side;
    boolean isDamaged;
    public Camera(int side) {
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

    public void setIsDamaged(boolean damaged) {
        isDamaged = damaged;
    }

    @Override
    public void accept(Visitor visitor) {
        if (Rand.rand() <= Config.DAMAGE_PERCENTAGE) {
            //System.out.println("Error detected: " + this);
            visitor.addPart(this);
            visitor.addCategory(Rand.randError());
        };
    }
}
