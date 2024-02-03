package org.truck.truckParts;

import org.truck.observer.TrailerDetector;
import org.truck.vehicle.Trailor;

public class Hitch{
    private boolean connected = false;
    Trailor trailor;
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

    public Trailor getTrailor() {
        return trailor;
    }

    public void setTrailor(Trailor trailor) {
        this.trailor = trailor;
    }
}
