package org.truck.trailerParts.Loading;

import org.truck.CentralUnit;
import org.truck.entity.LoadingScheme;
import org.truck.helper.Json;

public class LoadingArea {
    CentralUnit centralUnit;
    LoadingSpace[] loadingSpace = new LoadingSpace[16];
    public LoadingArea() {
        for (int i=0; i<loadingSpace.length; i++) {
            loadingSpace[i] = new LoadingSpace(i);
        }
    }

    public void loadTrailer() {
        LoadingScheme l = Json.readParameters();
        System.out.println(l);
    }

    public void setCentralUnit(CentralUnit centralUnit) {
        this.centralUnit = centralUnit;
        for (int i=0; i<loadingSpace.length; i++) {
            loadingSpace[i].setCentralUnit(this.centralUnit);
        }
    }
}
