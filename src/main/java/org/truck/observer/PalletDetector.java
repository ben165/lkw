package org.truck.observer;

import java.util.ArrayList;

public class PalletDetector {
    private final ArrayList<IPalletListener> listenerList;

    public PalletDetector() {
        listenerList = new ArrayList<>();
    }

    public void palletDetected(int location, int isPallet) {
        for (IPalletListener listener : listenerList) {
            listener.palletDetected(location, isPallet);
        }
    }

    public void addListener(IPalletListener listener) {
        listenerList.add(listener);
    }

    public void removeListener(IPalletListener listener) {
        listenerList.remove(listener);
    }
}
