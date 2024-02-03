package org.truck.trailerParts.Loading;

import org.truck.entity.LoadingScheme;
import org.truck.helper.Json;

public class LoadingArea {
    Pallet[][] pallets = new Pallet[8][2];
    public LoadingArea() {

    }


    public void loadTrailer() {
        LoadingScheme l = Json.readParameters();
        System.out.println(l);
    }

}
