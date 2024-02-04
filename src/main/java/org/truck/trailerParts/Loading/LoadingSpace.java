package org.truck.trailerParts.Loading;

import org.truck.CentralUnit;

public class LoadingSpace {
    Pallet pallet;
    int number;
    CentralUnit centralUnit;

    public LoadingSpace(int number) {
        this.number = number;
    }

    public void setCentralUnit(CentralUnit centralUnit) {
        this.centralUnit = centralUnit;
    }

    public void placePallet(Pallet pallet) {
        this.pallet = pallet;
        // Meldung an CentralUnit
    }
}
