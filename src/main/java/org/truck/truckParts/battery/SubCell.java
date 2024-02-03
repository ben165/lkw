package org.truck.truckParts.battery;

import java.util.ArrayList;
import java.util.List;

public class SubCell extends ACell {
    private final List<ACell> cellList = new ArrayList<>();

    public SubCell() {
        super();
    }
    @Override
    public void add(ACell cell) {
        cellList.add(cell);
    }

    @Override
    public ACell getChild(int i) {
        return cellList.get(i);
    }

    @Override
    public int getStatus() {
        return 0;
    }

    @Override
    public void setStatus(int status) {}

}
