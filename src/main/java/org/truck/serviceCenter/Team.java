package org.truck.serviceCenter;

import org.truck.commands.ICommand;

public class Team {
    Supervisor supervisor;
    OperationTeamManager operationTeamManager;
    EmergencyTeamManager emergencyTeamManager;

    Manager[] managers = new Manager[2];

    public Team() {
        supervisor = new Supervisor();
        operationTeamManager = new OperationTeamManager();
        emergencyTeamManager = new EmergencyTeamManager();
        managers[0] = emergencyTeamManager;
        managers[1] = operationTeamManager;
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

    public int getCorrectManager(String category) {
        
        return 1;
    }
}
