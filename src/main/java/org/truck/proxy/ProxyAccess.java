package org.truck.proxy;

import org.truck.serviceCenter.TechnicalEngineer;

public class ProxyAccess implements IAccess {
    TechnicalEngineer technicalEngineer;

    public ProxyAccess(TechnicalEngineer technicalEngineer) {
        this.technicalEngineer = technicalEngineer;
    }


    @Override
    public boolean grant() {
        if (technicalEngineer.getPassword().equals("abc")) {
            return true;
        }
        return false;
    }
}
