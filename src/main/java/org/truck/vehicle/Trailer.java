package org.truck.vehicle;

import org.truck.parts.Indicators;
import org.truck.parts.Brakelight;
import org.truck.parts.axle.FixedAxle;
import org.truck.trailerParts.Loading.LoadingArea;
import org.truck.trailerParts.TrailerChassis;
import org.truck.trailerParts.TrailerCoupler;
import org.truck.trailerParts.mediator.TrailerMediator;
import org.truck.truckParts.mediator.TruckMediator;

import java.util.Arrays;

public class Trailer {
    public final TrailerMediator trailerMediator;
    private final int amountBackAxles;
    private final TrailerChassis trailerChassis;
    private final TrailerCoupler trailerCoupler;
    public final LoadingArea loadingArea;
    private final FixedAxle[] backAxles;
    private final Brakelight[] brakelights;
    private final Indicators tailBlinker;

    private Trailer(Builder builder) {
        this.trailerMediator = builder.trailerMediator;
        this.amountBackAxles = builder.amountBackAxles;
        this.trailerChassis = builder.trailerChassis;
        this.trailerCoupler = builder.trailerCoupler;
        this.loadingArea = builder.loadingArea;
        this.backAxles = builder.backAxles;
        this.brakelights = builder.brakelights;
        this.tailBlinker = builder.tailIndicators;
    }

    public static class Builder {
        private TrailerMediator trailerMediator;
        private int amountBackAxles;
        private TrailerChassis trailerChassis;
        private TrailerCoupler trailerCoupler;
        private LoadingArea loadingArea;
        private FixedAxle[] backAxles;
        private Brakelight[] brakelights;
        private Indicators tailIndicators;


        public Builder trailerMediator() {
            this.trailerMediator = new TrailerMediator();
            return this;
        }
        public Builder trailerChassis() {
            this.trailerChassis = new TrailerChassis();
            return this;
        }
        public Builder trailerCoupler() {
            this.trailerCoupler = new TrailerCoupler();
            return this;
        }
        public Builder loadingArea() {
            this.loadingArea = new LoadingArea();
            return this;
        }
        public Builder backAxles(int axles) {
            this.amountBackAxles = axles;
            this.backAxles = new FixedAxle[axles];
            for (int i=0; i<axles; i++) {
                backAxles[i] = new FixedAxle();
            }
            return this;
        }
        public Builder brakeLights() {
            this.brakelights = new Brakelight[2];
            this.brakelights[0] = new Brakelight();
            this.brakelights[1] = new Brakelight();
            return this;
        }

        public Builder tailBlinkers() {
            this.tailIndicators = new Indicators();
            return this;
        }

        public Trailer build() {
            return new Trailer(this);
        }

    }

    public boolean checkTrailerBuilder() {

        // Chassis
        if (this.trailerChassis == null) {
            return false;
        }
        // Indicator(s)
        if (this.tailBlinker == null) {
            return false;
        }
        // Brakelights
        if (this.brakelights == null) {
            return false;
        }
        // Axles
        if (this.backAxles == null) {
            return false;
        }
        // Coupler
        if (this.trailerCoupler == null) {
            return false;
        }
        // Loading Area
        if (this.loadingArea == null) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Trailer{" + "\n" +
                "trailerMediator=" + trailerMediator +"\n" +
                ", amountBackAxles=" + amountBackAxles +"\n" +
                ", trailerChassis=" + trailerChassis +"\n" +
                ", trailerCoupler=" + trailerCoupler +"\n" +
                ", loadingArea=" + loadingArea +"\n" +
                ", backAxles=" + Arrays.toString(backAxles) +"\n" +
                ", brakelights=" + Arrays.toString(brakelights) +"\n" +
                ", tailBlinker=" + tailBlinker +"\n" +
                '}';
    }
}
