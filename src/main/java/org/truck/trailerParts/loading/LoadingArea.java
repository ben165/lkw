package org.truck.trailerParts.loading;

import org.truck.CentralUnit;
import org.truck.observer.PalletDetector;

public class LoadingArea {
    CentralUnit centralUnit;
    PalletDetector palletDetector = new PalletDetector();
    Pallet[] palletArray = new Pallet[16];

    public LoadingArea() {

    }

    public void setCentralUnit(CentralUnit centralUnit) {
        this.centralUnit = centralUnit;
        palletDetector.addListener(centralUnit);
    }

    public void placePallet(int position, int isPallet) {
        if (isPallet == 1) {
            Pallet pallet = new Pallet();
            this.palletArray[position] = pallet;
        }
        palletDetector.palletDetected(position, isPallet);
    }
}
