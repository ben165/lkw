package org.truck.truckParts.battery;

import java.util.ArrayList;
import java.util.List;

public class Battery extends ACell{
    private final int amountMainCells = 500;
    private final int amountSubCells = 100;
    private final int amountCells = 5;
    private final List<ACell> mainCells = new ArrayList<>();
    Battery() {
        for (int k=0; k<amountMainCells; k++) {
            MainCell mainCell = new MainCell();
            mainCells.add(mainCell);
            for (int j = 0; j < amountSubCells; j++) {
                SubCell subCell = new SubCell();
                mainCells.get(k).add(subCell);
                for (int i = 0; i < amountCells; i++) {
                    Cell cell = new Cell();
                    cell.setStatus(1);
                    mainCells.get(k).getChild(j).add(cell);
                }
            }
        }
    }

    @Override
    public void add(ACell cell) {
        mainCells.add(cell);
    }

    @Override
    public ACell getChild(int i) {
        return mainCells.get(i);
    }

    @Override
    public int getStatus() {
        return 0;
    }

    @Override
    public void setStatus(int status) {}


    int sum = 0;
    public int getAvailableEnergy() {
        for (int i=0; i<amountMainCells; i++) {
            for (int j=0; j<amountSubCells; j++) {
                for (int k=0; k<amountCells; k++) {
                    var temp = mainCells.get(i).getChild(j).getChild(k).getStatus();
                    sum += temp;
                }
            }
        }
        return sum;
    }

}
