package org.truck.trailerParts.loading;

import org.truck.CentralUnit;
import org.truck.observer.PalletDetector;

public class StoragePlace {
    PalletDetector palletDetector;
    int pos;

    Pallet pallet;
    public StoragePlace(int pos, CentralUnit centralUnit) {
        palletDetector = new PalletDetector(pos, centralUnit);
        this.pos = pos;
    }

    public void setPallet() {
        this.pallet = new Pallet();
        palletDetector.palletDetected(this.pos);
    }
}
