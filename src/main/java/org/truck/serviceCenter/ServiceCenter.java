package org.truck.serviceCenter;

public class ServiceCenter {
    Team sensorTeam;
    Team engineTeam;
    Team[] teams = new Team[2];
    int team;

    public ServiceCenter() {
        engineTeam = new EngineTeam();
        sensorTeam = new SensorTeam();
        teams[0] = engineTeam;
        teams[1] = sensorTeam;
    }

    public Team getSensorTeam() {
        return sensorTeam;
    }

    public void setSensorTeam(SensorTeam sensorTeam) {
        this.sensorTeam = sensorTeam;
    }

    public Team getEngineTeam() {
        return engineTeam;
    }

    public void setEngineTeam(EngineTeam engineTeam) {
        this.engineTeam = engineTeam;
    }

    public Team[] getTeams() {
        return teams;
    }

    public void setTeams(Team[] teams) {
        this.teams = teams;
    }

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }
}
