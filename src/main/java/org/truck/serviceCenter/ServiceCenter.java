package org.truck.serviceCenter;

public class ServiceCenter {
    EngineTeam engineTeam;
    SensorTeam sensorTeam;
    Team[] teams = new Team[2];
    int team;

    public ServiceCenter() {
        engineTeam = new EngineTeam();
        sensorTeam = new SensorTeam();
        teams[0] = engineTeam;
        teams[1] = sensorTeam;
    }

    public Team[] getTeams() {
        return teams;
    }

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }
}
