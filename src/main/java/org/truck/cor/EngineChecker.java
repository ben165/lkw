package org.truck.cor;

import org.truck.truckParts.Engine;

public class EngineChecker extends Checker implements IChecker {
    public void check(Object part) {
        if (canHandlePart(part)) {
            //System.out.println("Engine Team needs to check: " + part);
            getServiceCenter().setTeam(0);
        } else {
            super.check(part);
        }
    }

    @Override
    public boolean canHandlePart(Object part) {
        return (part == null) || (part instanceof Engine);
    }
}

