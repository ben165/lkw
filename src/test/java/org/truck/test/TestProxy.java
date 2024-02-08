package org.truck.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.truck.CentralUnit;
import org.truck.cor.CheckPart;
import org.truck.helper.SimpleBuilder;
import org.truck.proxy.ProxyAccess;
import org.truck.proxy.RepairRobot;
import org.truck.serviceCenter.Manager;
import org.truck.serviceCenter.ServiceCenter;
import org.truck.serviceCenter.Supervisor;
import org.truck.serviceCenter.TechnicalEngineer;
import org.truck.truckParts.Engine;
import org.truck.vehicle.Trailer;
import org.truck.vehicle.Truck;

import static org.junit.jupiter.api.Assertions.*;

public class TestProxy {
    private Truck truck;
    private Trailer trailer;
    CentralUnit centralUnit;


    @BeforeEach
    public void setup() {
        truck = SimpleBuilder.createTruck(2);
        //trailer = SimpleBuilder.createTrailer(2);
        centralUnit = new CentralUnit(truck);
    }

    @Test()
    @Order(1)
    public void testProxy() {
        ServiceCenter serviceCenter = new ServiceCenter();
        Engine engine = new Engine();
        engine.setIsDamaged(true);

        assertTrue(engine.getIsDamaged());

        CheckPart checkPart = new CheckPart();
        checkPart.setServiceCenter(serviceCenter);
        checkPart.check(engine);

        Supervisor supervisor = serviceCenter.getTeams()[serviceCenter.getTeam()].getSupervisor();
        int nr = serviceCenter.getTeams()[serviceCenter.getTeam()].getCorrectManager("E01");
        Manager manager = serviceCenter.getTeams()[serviceCenter.getTeam()].getManagers()[nr];
        TechnicalEngineer engineer = manager.getTechnicalEngineers()[0];

        engineer.setPassword(supervisor.getPw());

        ProxyAccess proxyAccess = new ProxyAccess(engineer);

        RepairRobot repairRobot = new RepairRobot(proxyAccess, engine);

        assertFalse(engine.getIsDamaged());

    }
}
