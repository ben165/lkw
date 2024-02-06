package org.truck.serviceCenter;

public class EngineTeam extends Team{
    Supervisor supervisor;
    OperationTeamManager operationTeamManager;
    EmergencyTeamManager emergencyTeamManager;

    public EngineTeam() {
        supervisor = new Supervisor();
        operationTeamManager = new OperationTeamManager();
        emergencyTeamManager = new EmergencyTeamManager();
    }

}
