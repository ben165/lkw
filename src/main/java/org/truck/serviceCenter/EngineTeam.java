package org.truck.serviceCenter;

public class EngineTeam{
    Supervisor supervisor;
    OperationTeamManager operationTeamManager;
    EmergencyTeamManager emergencyTeamManager;

    public EngineTeam() {
        supervisor = new Supervisor();
        operationTeamManager = new OperationTeamManager();
        emergencyTeamManager = new EmergencyTeamManager();
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public OperationTeamManager getOperationTeamManager() {
        return operationTeamManager;
    }

    public EmergencyTeamManager getEmergencyTeamManager() {
        return emergencyTeamManager;
    }
}
