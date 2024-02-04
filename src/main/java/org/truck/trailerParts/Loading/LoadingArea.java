package org.truck.trailerParts.Loading;

import org.truck.CentralUnit;
import org.truck.entity.LoadingScheme;
import org.truck.helper.Json;

public class LoadingArea {
    CentralUnit centralUnit;
    Pallet[] palletArray = new Pallet[16];

    public LoadingArea(){

    }

    public void setCentralUnit(CentralUnit centralUnit) {
        this.centralUnit = centralUnit;
    }

    public void placePallet(int position) {
        Pallet pallet = new Pallet();
        this.palletArray[position] = pallet;
    }

    public void loadTrailer() {
        LoadingScheme plan = Json.readParameters();

        // Flatmapping
        for (int i=0; i<plan.getLeft().size(); i++) {
            int isLoaded = plan.getLeft().get(i);
            System.out.println( isLoaded );
            if( isLoaded == 1) {

            }

        }
        for (int i=0; i<plan.getRight().size(); i++) {
            System.out.println( plan.getRight().get(i) );
        }
    }
}
