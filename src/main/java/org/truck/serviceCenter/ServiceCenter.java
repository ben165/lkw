package org.truck.serviceCenter;

public class ServiceCenter {

    SensorTeam sensorTeam;
    EngineTeam engineTeam;
    Team nextResponsibleTeam;

    public ServiceCenter() {
        engineTeam = new EngineTeam();
        sensorTeam = new SensorTeam();
    }
}
