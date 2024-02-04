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

    public void placePallet(int position) {
        Pallet pallet = new Pallet();
        this.palletArray[position] = pallet;
    }

    public void loadTrailer() {
        LoadingScheme plan = Json.readParameters();

        // Flatmapping
        int counter = 0;
        int isLoaded;

        // Left site
        for (int i=0; i<plan.getLeft().size(); i++) {
            isLoaded = plan.getLeft().get(i);
            if (isLoaded != 0) {
                palletDetector.palletDetected(counter);
            }
            counter++;
        }

        // Right site
        for (int i=0; i<plan.getRight().size(); i++) {
            isLoaded = plan.getRight().get(i);
            if (isLoaded != 0) {
                palletDetector.palletDetected(counter);
            }
            counter++;
        }
    }
}
