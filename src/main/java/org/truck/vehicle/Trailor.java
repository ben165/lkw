package org.truck.vehicle;

import org.truck.parts.Indicators;
import org.truck.parts.Brakelight;
import org.truck.parts.axle.FixedAxle;
import org.truck.trailerParts.Loading.LoadingArea;
import org.truck.trailerParts.TrailerChassis;
import org.truck.trailerParts.TrailerCoupler;

import java.util.Arrays;

public class Trailor {
    private final TrailerChassis trailerChassis;
    private final TrailerCoupler trailerCoupler;
    private final LoadingArea loadingArea;
    private final FixedAxle[] backAxles;
    private final Brakelight[] brakelights;
    private final Indicators tailBlinker;

    private Trailor (Builder builder) {
        this.trailerChassis = builder.trailerChassis;
        this.trailerCoupler = builder.trailerCoupler;
        this.loadingArea = builder.loadingArea;
        this.backAxles = builder.backAxles;
        this.brakelights = builder.brakelights;
        this.tailBlinker = builder.tailIndicators;
    }

    public static class Builder {
        private TrailerChassis trailerChassis;
        private TrailerCoupler trailerCoupler;
        private LoadingArea loadingArea;
        private FixedAxle[] backAxles;
        private Brakelight[] brakelights;
        private Indicators tailIndicators;

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
            this.backAxles = new FixedAxle[axles];
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

        public Trailor build() {
            return new Trailor(this);
        }

    }

    @Override
    public String toString() {
        return "Trailor{" +
                "trailerChassis=" + trailerChassis + "\n" +
                ", trailerCoupler=" + trailerCoupler + "\n" +
                ", loadingArea=" + loadingArea + "\n" +
                ", backAxles=" + Arrays.toString(backAxles) + "\n" +
                ", brakelights=" + Arrays.toString(brakelights) + "\n" +
                ", tailBlinker=" + tailBlinker + "\n" +
                '}';
    }
}
