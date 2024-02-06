package org.truck.serviceCenter;

public class EngineTeam extends Team{

    public EngineTeam() {
        super();
    }

    @Override
    public OperationTeamManager getOperationTeamManager() {
        return super.getOperationTeamManager();
    }

    @Override
    public EmergencyTeamManager getEmergencyTeamManager() {
        return super.getEmergencyTeamManager();
    }
}
