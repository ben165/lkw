package org.truck.serviceCenter;

import org.truck.commands.ICommand;

public class Team {
    Supervisor supervisor;
    OperationTeamManager operationTeamManager;
    EmergencyTeamManager emergencyTeamManager;

    public Team() {
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
