package org.truck.truckParts;

import org.truck.observer.TrailerDetector;
import org.truck.vehicle.Trailer;

public class Hitch{
    private boolean connected = false;
    Trailer trailer;
    TrailerDetector trailerDetector;
    public Hitch() {
        trailerDetector = new TrailerDetector();
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    public TrailerDetector getTrailerDetector() {
        return trailerDetector;
    }

    public void setTrailerDetector(TrailerDetector trailerDetector) {
        this.trailerDetector = trailerDetector;
    }

    public Trailer getTrailor() {
        return trailer;
    }

    public void setTrailor(Trailer trailer) {
        this.trailer = trailer;
    }
}
