package org.truck.truckParts;

import org.truck.CentralUnit;
import org.truck.observer.TrailerDetector;
import org.truck.vehicle.Trailer;

public class Clutch {
    private boolean connected = false;
    TrailerDetector trailerDetector;
    public Clutch() {
        trailerDetector = new TrailerDetector();
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(Trailer trailer) {
        this.connected = true;
        trailerDetector.trailerConnected(trailer);
    }

    public void setCentralUnit(CentralUnit centralUnit) {
        trailerDetector.addListener(centralUnit);
    }
}
