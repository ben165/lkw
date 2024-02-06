package org.truck.serviceCenter;

public class ServiceCenter {

    Team sensorTeam;
    Team engineTeam;
    Team nextResponsibleTeam;

    public ServiceCenter() {
        engineTeam = new EngineTeam();
        sensorTeam = new SensorTeam();
    }
}
