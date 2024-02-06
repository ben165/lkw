package org.truck.cor;

import org.truck.serviceCenter.ServiceCenter;
import org.truck.serviceCenter.Team;

public class Checker {
    private Checker successor;
    private ServiceCenter serviceCenter;

    public void check(Object part) {
        if (getSuccessor() != null) {
            getSuccessor().check(part);
        } else {
            System.out.println("unable to find correct team : " + part);
        }
    }

    public Checker getSuccessor() {
        return successor;
    }

    public void setSuccessor(Checker successor) {
        this.successor = successor;
    }

    public ServiceCenter getServiceCenter() {
        return serviceCenter;
    }

    public void setServiceCenter(ServiceCenter serviceCenter) {
        this.serviceCenter = serviceCenter;
    }
}
