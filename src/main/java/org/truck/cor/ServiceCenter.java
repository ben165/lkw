package org.truck.cor;

public class ServiceCenter {

    SensorTeam sensorTeam;
    EngineTeam engineTeam;

    public ServiceCenter() {
        engineTeam = new EngineTeam();
        sensorTeam = new SensorTeam();
    }

    public SensorTeam getSensorTeam() {
        return sensorTeam;
    }

    public EngineTeam getEngineTeam() {
        return engineTeam;
    }

    public void repair(Object o) {

    }

}
