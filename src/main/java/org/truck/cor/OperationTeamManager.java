package org.truck.cor;

public class OperationTeamManager {
    TechnicalEngineer[] technicalEngineers = new TechnicalEngineer[3];
    public OperationTeamManager() {
        for (int i=0; i< technicalEngineers.length; i++) {
            technicalEngineers[i] = new TechnicalEngineer();
        }
    }

    public TechnicalEngineer[] getTechnicalEngineers() {
        return technicalEngineers;
    }
}
