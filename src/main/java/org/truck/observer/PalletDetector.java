package org.truck.observer;

import org.truck.CentralUnit;

import java.util.ArrayList;

public class PalletDetector {
    private final ArrayList<IPalletListener> listenerList = new ArrayList<>();;
    int pos;

    public PalletDetector(int pos, CentralUnit centralUnit) {
        this.pos = pos;
        this.addListener(centralUnit);
    }

    public void palletDetected(int location) {
        for (IPalletListener listener : listenerList) {
            listener.palletDetected(location);
        }
    }

    public void addListener(IPalletListener listener) {
        listenerList.add(listener);
    }

    public void removeListener(IPalletListener listener) {
        listenerList.remove(listener);
    }
}
