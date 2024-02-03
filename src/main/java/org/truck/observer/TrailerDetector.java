package org.truck.observer;

import java.util.ArrayList;

public class TrailerDetector {
    private final ArrayList<ITrailerListener> listenerList;

    public TrailerDetector() {
        listenerList = new ArrayList<>();
    }

    public void falseAlarm() {
        for (ITrailerListener listener : listenerList) {
            listener.trailerDetected("SmokeDetector #1");
        }
    }

    public void addListener(ITrailerListener listener) {
        listenerList.add(listener);
    }

    public void removeListener(ITrailerListener listener) {
        listenerList.remove(listener);
    }
}
