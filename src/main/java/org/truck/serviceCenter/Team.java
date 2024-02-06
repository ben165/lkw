package org.truck.serviceCenter;

import org.truck.commands.ICommand;

public class Team {
    EngineTeam engineTeam;
    SensorTeam sensorTeam;

    public Team(){
        engineTeam = new EngineTeam();
        sensorTeam = new SensorTeam();
    }
}
