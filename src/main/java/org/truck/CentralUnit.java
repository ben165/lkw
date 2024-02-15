package org.truck;

import com.google.common.hash.Hashing;
import org.truck.commands.*;
import org.truck.helper.LoadPlanFlat;
import org.truck.observer.IPalletListener;
import org.truck.observer.ITrailerListener;
import org.truck.state.Inactive;
import org.truck.state.State;
import org.truck.truckParts.mediator.TruckMediator;
import org.truck.vehicle.Trailer;
import org.truck.vehicle.Truck;

import java.nio.charset.StandardCharsets;

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
    private LoadPlanFlat loadPlanFlat;
    private final State state;
    boolean isLoadingCorrect;


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

    public void moveStraight(int percentage) {
        control.setCommand(moveStraight);
        control.action(percentage);
    }

    public void turnLeft(int angle, int percentage) {
        control.setCommand(turnLeft);
        control.action(angle, percentage);
    }

    public void turnRight(int angle, int percentage) {
        control.setCommand(turnRight);
        control.action(angle, percentage);
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
                moveStraight(0);
            } else {
                cameraOff();
                lidarOff();
                engineOff();
                moveStraight(0);
            }
        }
    }

    public boolean isTrailerIsConnected() {
        return trailerIsConnected;
    }

    public boolean loadingResult() {
        return isLoadingCorrect;
    }

    public State getState() {
        return state;
    }

    @Override
    public void trailerDetected(Trailer trailer) {
        this.trailerIsConnected = true;
        this.trailer = trailer;
        this.isLoadingCorrect = false;
        this.loadPlanFlat = null;
    }

    @Override
    public void palletDetected(int location) {
        if (loadPlanFlat == null) {
            loadPlanFlat = new LoadPlanFlat("loadingPlan.json");
            isLoadingCorrect = false;
        }

        loadPlanFlat.updatePlan(location);

        if (loadPlanFlat.isLoadingFinished()) {
            isLoadingCorrect = true;
            loadPlanFlat = null;
            //System.out.println("Loading finished");
        }
    }
}
