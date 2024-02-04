package org.truck.truckParts;

import org.truck.CentralUnit;
import org.truck.observer.TrailerDetector;
import org.truck.vehicle.Trailer;

public class Hitch{
    private boolean connected = false;
    TrailerDetector trailerDetector;
    public Hitch() {
        trailerDetector = new TrailerDetector();
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
        trailerDetector.trailerConnected();
    }

    public void setCentralUnit(CentralUnit centralUnit) {
        trailerDetector.addListener(centralUnit);
    }
}
