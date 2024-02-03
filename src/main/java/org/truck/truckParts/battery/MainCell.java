package org.truck.truckParts.battery;

import java.util.ArrayList;
import java.util.List;

public class MainCell extends ACell {
    private final List<ACell> subCellList = new ArrayList<>();

    public MainCell() {
        super();
    }

    @Override
    public void add(ACell cell) {
        subCellList.add(cell);
    }

    @Override
    public ACell getChild(int i) {
        return subCellList.get(i);
    }

    @Override
    public int getStatus() {
        return 0;
    }

    @Override
    public void setStatus(int status) {

    }


}
