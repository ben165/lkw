package org.truck.serviceCenter;

public class EmergencyTeamManager {
    TechnicalEngineer[] technicalEngineers = new TechnicalEngineer[3];

    public EmergencyTeamManager() {
        for (int i = 0; i< technicalEngineers.length; i++) {
            technicalEngineers[i] = new TechnicalEngineer();
        }
    }

    public TechnicalEngineer[] getTechnicalEngineers() {
        return technicalEngineers;
    }
}
