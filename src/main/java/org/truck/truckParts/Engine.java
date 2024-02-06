package org.truck.truckParts;

import org.truck.Config;
import org.truck.helper.Rand;
import org.truck.truckParts.battery.Battery;
import org.truck.visitor.IVisitor;
import org.truck.visitor.Visitor;

public class Engine implements IVisitor {
    private boolean engineOn = false;
    private int engineSpeed = 0;
    private Battery battery;
    boolean isDamaged;

    public boolean isEngineOn() {
        return engineOn;
    }

    public void setEngineOn(boolean engineOn) {
        this.engineOn = engineOn;
    }

    public int getEngineSpeed() {
        return engineSpeed;
    }

    public void setEngineSpeed(int engineSpeed) {
        this.engineSpeed = engineSpeed;
        // energy consumption
        battery.unload(2*engineSpeed);
    }

    public Battery getBattery() {
        return battery;
    }

    public void setBattery(Battery battery) {
        this.battery = battery;
    }

    public boolean getIsDamaged() {
        return isDamaged;
    }

    public void setIsDamaged(boolean isDamaged) {
        this.isDamaged = isDamaged;
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
