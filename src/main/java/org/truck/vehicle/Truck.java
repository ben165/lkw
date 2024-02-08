package org.truck.vehicle;

import org.truck.CentralUnit;
import org.truck.eventBus.Publisher;
import org.truck.parts.Brakelight;
import org.truck.parts.Indicators;
import org.truck.parts.axle.FixedAxle;
import org.truck.parts.axle.TurningAxle;
import org.truck.truckParts.*;
import org.truck.truckParts.battery.Battery;
import org.truck.truckParts.mediator.TruckMediator;
import org.truck.visitor.Visitor;

import static org.truck.helper.PositionEnum.LEFT;
import static org.truck.helper.PositionEnum.RIGHT;

public class Truck {
    public final TruckMediator truckMediator;
    private Trailer trailer;
    private final TruckChassis truckChassis;
    private final Cabin cabin;
    private final Engine engine;
    private final Battery battery;
    private final TurningAxle frontAxle;
    private final FixedAxle[] backAxles;
    private final Headlight[] headLights;
    private final Mirror[] mirrors;
    private final Indicators frontIndicators;
    private final Indicators tailIndicators;
    private final Brakelight[] brakelights;
    public final Clutch clutch;
    public final Cable cable;
    private CentralUnit centralUnit;
    private Visitor visitor;



    private Truck(Builder builder) {
        this.truckMediator = builder.truckMediator;
        this.truckChassis = builder.truckChassis;
        this.cabin = builder.cabin;
        this.engine = builder.engine;
        this.battery = builder.battery;
        this.frontAxle = builder.frontAxle;
        this.backAxles = builder.backAxles;
        this.headLights = builder.headLights;
        this.mirrors = builder.mirrors;
        this.frontIndicators = builder.frontIndicators;
        this.tailIndicators = builder.tailIndicators;
        this.brakelights = builder.brakelights;
        this.clutch = builder.clutch;
        this.cable = builder.cable;
    }

    public static class Builder {
        private TruckMediator truckMediator;
        private TruckChassis truckChassis;
        private Cabin cabin;
        private Engine engine;
        private Battery battery;
        private TurningAxle frontAxle;
        private FixedAxle[] backAxles;
        private Headlight[] headLights;
        private Mirror[] mirrors;
        private Indicators frontIndicators;
        private Indicators tailIndicators;
        private Brakelight[] brakelights;
        private Clutch clutch;
        private Cable cable;

        public Builder truckMediator() {
            this.truckMediator = new TruckMediator();
            return this;
        }

        public Builder truckChassis() {
            this.truckChassis = new TruckChassis();
            return this;
        }

        public Builder cabin() {
            this.cabin = new Cabin();
            return this;
        }

        public Builder battery() {
            this.battery = new Battery();
            return this;
        }

        public Builder engine() {
            this.engine = new Engine();
            this.engine.setBattery(this.battery);
            return this;
        }

        public Builder frontAxle() {
            this.frontAxle = new TurningAxle();
            this.truckMediator.setFrontAxle(this.frontAxle);
            return this;
        }

        public Builder backAxles(int axles) {
            this.backAxles = new FixedAxle[axles];
            for (int i = 0; i < axles; i++) {
                backAxles[i] = new FixedAxle();
            }
            this.truckMediator.setBackAxles(this.backAxles);
            return this;
        }

        public Builder headlights() {
            this.headLights = new Headlight[2];
            this.headLights[LEFT.ordinal()] = new Headlight();
            this.headLights[RIGHT.ordinal()] = new Headlight();
            this.truckMediator.setHeadlight(this.headLights);
            return this;
        }

        public Builder mirrors() {
            this.mirrors = new Mirror[2];
            this.mirrors[LEFT.ordinal()] = new Mirror(LEFT.ordinal());
            this.mirrors[RIGHT.ordinal()] = new Mirror(RIGHT.ordinal());
            this.truckMediator.setMirrors(this.mirrors);
            return this;
        }

        public Builder frontBlinkers() {
            this.frontIndicators = new Indicators();
            this.truckMediator.setFrontIndicators(this.frontIndicators);
            return this;
        }

        public Builder tailBlinkers() {
            this.tailIndicators = new Indicators();
            this.truckMediator.setTailIndicators(this.tailIndicators);
            return this;
        }

        public Builder brakeLights() {
            this.brakelights = new Brakelight[2];
            this.brakelights[LEFT.ordinal()] = new Brakelight();
            this.brakelights[RIGHT.ordinal()] = new Brakelight();
            this.truckMediator.setBrakelight(this.brakelights);
            return this;
        }

        public Builder clutch() {
            this.clutch = new Clutch();
            return this;
        }

        public Builder cable() {
            this.cable = new Cable();
            return this;
        }

        public Truck build() {
            return new Truck(this);
        }
    }

    public void setCentralUnit(CentralUnit centralUnit) {
        this.centralUnit = centralUnit;
    }

    public void connectTrailerToClutch(Trailer trailer) {
        this.trailer = trailer;

        // Needed for loading sensors
        clutch.setCentralUnit(centralUnit);
        clutch.setConnected(trailer);

        // Needed for sensors
        trailer.loadingArea.setCentralUnit(centralUnit);
    }

    public void connectCableToTrailer() {
        var publisher = new Publisher();
        publisher.addListener(trailer.getTrailerMediator());
        truckMediator.setPublisher(publisher);
    }

    public void disconnectCableFromTrailer() {
        truckMediator.getPublisher().removeAllListener();
        truckMediator.setPublisher(null);
    }

    public Engine getEngine() {
        return engine;
    }

    public TurningAxle getFrontAxle() {
        return frontAxle;
    }

    public FixedAxle[] getBackAxles() {
        return backAxles;
    }

    public Mirror[] getMirrors() {
        return mirrors;
    }

    public Indicators getFrontIndicators() {
        return frontIndicators;
    }

    public Indicators getTailIndicators() {
        return tailIndicators;
    }

    public Brakelight[] getBrakelights() {
        return brakelights;
    }

    public void checkTruckPartsWithVisitor() {
        if (this.visitor == null) {
            this.visitor = new Visitor();
        }
        engine.accept(visitor);
        mirrors[LEFT.ordinal()].getCamera().accept(visitor);
        mirrors[RIGHT.ordinal()].getCamera().accept(visitor);
        mirrors[LEFT.ordinal()].getLidar().accept(visitor);
        mirrors[RIGHT.ordinal()].getLidar().accept(visitor);
    }

    public Visitor getVisitor() {
        return this.visitor;
    }

    public boolean checkTruckBuilder() {

        // Chassis
        if (this.truckChassis == null) {
            return false;
        }
        // Engine
        if (this.engine == null) {
            return false;
        }
        // Battery
        if (this.battery == null) {
            return false;
        }
        // frontAxle
        if (this.frontAxle == null) {
            return false;
        }
        // backAxle(s)
        for (int i = 0; i < backAxles.length; i++) {
            if (backAxles[i] == null) {
                return false;
            }
        }
        // Indicators front
        if (this.frontIndicators == null) {
            return false;
        }
        // Indicators tail
        if (this.tailIndicators == null) {
            return false;
        }
        // BrakeLights
        if (this.brakelights[LEFT.ordinal()] == null || this.brakelights[RIGHT.ordinal()] == null) {
            return false;
        }
        // Cabin
        if (this.cabin == null) {
            return false;
        }
        // Mirrors
        if (this.mirrors[LEFT.ordinal()] == null || this.mirrors[RIGHT.ordinal()] == null) {
            return false;
        }
        // Cameras
        if (this.mirrors[LEFT.ordinal()].getCamera() == null || this.mirrors[RIGHT.ordinal()].getCamera() == null) {
            return false;
        }
        // Lidars
        if (this.mirrors[LEFT.ordinal()].getLidar() == null || this.mirrors[RIGHT.ordinal()].getLidar() == null) {
            return false;
        }
        // Clutch
        if (this.clutch == null) {
            return false;
        }
        // Cable
        if (this.cable == null) {
            return false;
        }
        return true;
    }
}
