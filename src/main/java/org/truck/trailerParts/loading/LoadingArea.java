package org.truck.trailerParts.loading;

import org.truck.CentralUnit;
import org.truck.observer.PalletDetector;

public class LoadingArea {
    StoragePlace[] storagePlaces = new StoragePlace[16];

	// +---------+
	// | 0  | 8  |
	// | 1  | 9  |
	// | 2  | 10 |
	// | 3  | 11 |
	// | 4  | 12 |
	// | 5  | 13 |
	// | 6  | 14 |
	// | 7  | 15 |
	// +---------+    

    public LoadingArea() {

    }

    public void setPallet(int pos) {
        storagePlaces[pos].setPallet();
    }

    public void setCentralUnit(CentralUnit centralUnit) {
        for (int i=0; i<16; i++) {
            storagePlaces[i] = new StoragePlace(i, centralUnit);
        }
    }
}
