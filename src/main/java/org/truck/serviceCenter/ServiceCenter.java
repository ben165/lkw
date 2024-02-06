package org.truck.serviceCenter;

public class ServiceCenter {
    SensorTeam sensorTeam;
    EngineTeam engineTeam;
    Team nextResponsibleTeam;

    public ServiceCenter() {
        engineTeam = new EngineTeam();
        sensorTeam = new SensorTeam();
    }

    public SensorTeam getSensorTeam() {
        return sensorTeam;
    }

    public void setSensorTeam(SensorTeam sensorTeam) {
        this.sensorTeam = sensorTeam;
    }

    public EngineTeam getEngineTeam() {
        return engineTeam;
    }

    public void setEngineTeam(EngineTeam engineTeam) {
        this.engineTeam = engineTeam;
    }

    public Object getNextResponsibleTeam() {
        return nextResponsibleTeam;
    }

    public void setNextResponsibleTeam(Team nextResponsibleTeam) {
        this.nextResponsibleTeam = nextResponsibleTeam;
    }
}
