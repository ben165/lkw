package org.truck.cor3;

import org.truck.truckParts.Engine;

public class Checker {
    private Checker successor;

    public void check(Object part) {
        if (getSuccessor() != null) {
            getSuccessor().check(part);
        } else {
            System.out.println("unable to find correct parser : " + part);
        }
    }

    public Checker getSuccessor() {
        return successor;
    }

    public void setSuccessor(Checker successor) {
        this.successor = successor;
    }
}
