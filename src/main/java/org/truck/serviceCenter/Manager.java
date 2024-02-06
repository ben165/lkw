package org.truck.serviceCenter;

public abstract class Manager {
    TechnicalEngineer[] technicalEngineers = new TechnicalEngineer[3];

    public Manager() {
        for (int i = 0; i< technicalEngineers.length; i++) {
            technicalEngineers[i] = new TechnicalEngineer();
        }
    }

    public TechnicalEngineer[] getTechnicalEngineers() {
        return technicalEngineers;
    }
}
