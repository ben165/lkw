package org.truck;

import com.google.common.hash.Hashing;
import org.truck.commands.*;
import org.truck.helper.LoadPlanFlat;
import org.truck.observer.IPalletListener;
import org.truck.observer.ITrailerListener;
import org.truck.state.Inactive;
import org.truck.state.State;
import org.truck.vehicle.Trailer;
import org.truck.vehicle.Truck;
import org.truck.truckParts.mediator.TruckMediator;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class CentralUnit implements ITrailerListener, IPalletListener {
    private boolean trailerIsConnected = false;
    private Trailer trailer;
    private final Control control = new Control();
    private final TruckMediator mediator;
    private final ICommand brake;
    private final ICommand brakeLightsOff;
    private final ICommand brakeLightsOn;
    private final ICommand cameraOn;
    private final ICommand cameraOff;
    private final ICommand indicatorOn;
    private final ICommand indicatorOff;
    private final ICommand lidarOff;
    private final ICommand lidarOn;
    private final ICommand engineStart;
    private final ICommand engineShutdown;
    private final ICommand moveStraight;
    private final ICommand turnLeft;
    private final ICommand turnRight;
    private int[] realLoadingPlan;
    private final int[] actualLoadingPlan = new int[16];
    private final State state;


    public CentralUnit(Truck truck) {
        this.mediator = truck.truckMediator;

        brake = new Brake(this.mediator);

        brakeLightsOff = new BrakeLightOff(this.mediator);
        brakeLightsOn = new BrakeLightOn(this.mediator);

        cameraOff = new CameraOff(this.mediator);
        cameraOn = new CameraOn(this.mediator);

        indicatorOff = new IndicatorOff(this.mediator);
        indicatorOn = new IndicatorOn(this.mediator);

        lidarOff = new LidarOff(this.mediator);
        lidarOn = new LidarOn(this.mediator);

        engineStart = new EngineStart(truck);
        engineShutdown = new EngineShutdown(truck);

        moveStraight = new MoveStraight(truck);
        turnLeft = new TurnLeft(truck);
        turnRight = new TurnRight(truck);

        Arrays.fill(actualLoadingPlan, 0);

        state = new State();
        state.setState(new Inactive());
    }

    public void brake(int percentage) {
        control.setCommand(brake);
        control.action(percentage);
    }

    public void brakeLightsOff() {
        control.setCommand(brakeLightsOff);
        control.action();
    }

    public void brakeLightsOn() {
        control.setCommand(brakeLightsOn);
        control.action();
    }

    public void cameraOff() {
        control.setCommand(cameraOff);
        control.action();
    }

    public void cameraOn() {
        control.setCommand(cameraOn);
        control.action();
    }

    public void indicatorOn(int side) {
        //0 = left, 1 = right
        control.setCommand(indicatorOn);
        control.action(side);
    }

    public void indicatorOff() {
        // turns of every side
        control.setCommand(indicatorOff);
        control.action();
    }

    public void lidarOff() {
        control.setCommand(lidarOff);
        control.action();
    }

    public void lidarOn() {
        control.setCommand(lidarOn);
        control.action();
    }

    public void engineOn() {
        control.setCommand(engineStart);
        control.action();
    }

    public void engineOff() {
        control.setCommand(engineShutdown);
        control.action();
    }

    public void moveStraight() {
        control.setCommand(moveStraight);
        control.action();
    }

    public void turnLeft(int angle) {
        control.setCommand(turnLeft);
        control.action(angle);
    }

    public void turnRight(int angle) {
        control.setCommand(turnRight);
        control.action(angle);
    }

    public void receiver(String password) {
        String sha256Hex = Hashing.sha256()
                .hashString("Kodiak2024", StandardCharsets.UTF_8)
                .toString();

        if (password.equals(sha256Hex)) {
            state.change();

            if (state.getState().stateAsBoolean()) {
                cameraOn();
                lidarOn();
                engineOn();
                moveStraight();
            } else {
                cameraOff();
                lidarOff();
                engineOff();
                moveStraight();
            }
        }
    }

    public boolean isTrailerIsConnected() {
        return trailerIsConnected;
    }

    @Override
    public void trailerDetected(Trailer trailer) {
        System.out.println("Method in CU: Trailer connection: " + trailer.hashCode());
        this.trailerIsConnected = true;
        this.trailer = trailer;
    }

    @Override
    public void palletDetected(int location) {
        //System.out.println("Method in CU: Pallet placed on location: " + location);
        actualLoadingPlan[location] = 1;
        //System.out.println("Correct? " + intLoadingPlan[location]);
    }

    public boolean checkLoading() {
        for (int i = 0; i< realLoadingPlan.length; i++) {
            if (realLoadingPlan[i] != actualLoadingPlan[i]) {
                System.out.println(realLoadingPlan[i] + " != " + actualLoadingPlan[i]);
                return false;
            }
        }
        return true;
    }

    public State getState() {
        return state;
    }
}
