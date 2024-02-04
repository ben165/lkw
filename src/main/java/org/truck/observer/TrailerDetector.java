package org.truck.observer;

import org.truck.vehicle.Trailer;

import java.util.ArrayList;

public class TrailerDetector {
    private final ArrayList<ITrailerListener> listenerList;

    public TrailerDetector() {
        listenerList = new ArrayList<>();
    }

    public void trailerConnected(Trailer trailer) {
        for (ITrailerListener listener : listenerList) {
            listener.trailerDetected(trailer);
        }
    }

    public void addListener(ITrailerListener listener) {
        listenerList.add(listener);
    }

    public void removeListener(ITrailerListener listener) {
        listenerList.remove(listener);
    }
}
