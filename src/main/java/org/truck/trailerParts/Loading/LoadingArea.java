package org.truck.trailerParts.Loading;

import org.truck.CentralUnit;
import org.truck.entity.LoadingScheme;
import org.truck.helper.Json;
import org.truck.observer.PalletDetector;

public class LoadingArea {
    CentralUnit centralUnit;
    PalletDetector palletDetector = new PalletDetector();
    Pallet[] palletArray = new Pallet[16];

    public LoadingArea(){

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

    /*
    public void loadTrailer(String loadingPlan) {
        LoadingScheme plan = Json.readParameters(loadingPlan);

        // Flatmapping and filling with Pallets
        for (int i=0; i<plan.getLeft().size(); i++) {
            if (plan.getLeft().get(i) == 1) {
                palletDetector.palletDetected(i);
                palletArray[i] = new Pallet();
            }
            if (plan.getRight().get(i) == 1) {
                palletDetector.palletDetected(i+8);
                palletArray[i+8] = new Pallet();
            }
        }
    }
    */
}
