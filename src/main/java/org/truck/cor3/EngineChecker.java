package org.truck.cor3;

import org.truck.truckParts.Engine;

public class EngineChecker extends Checker implements IChecker{
    public void check(Object part) {
        if (canHandlePart(part)) {
            System.out.println("Engine checker : " + part);
        } else {
            super.check(part);
        }
    }

    @Override
    public boolean canHandlePart(Object part) {
        return (part == null) || (part instanceof Engine);
    }
}

