package org.truck.helper;

import org.truck.entity.LoadingScheme;

public class LoadPlanFlat {
    private final int[] intPlanArray = new int[16];
    boolean loadingFinished;

    public LoadPlanFlat(String filename) {
        LoadingScheme plan = Json.readParameters(filename);

        for (int i = 0; i < plan.getLeft().size(); i++) {
            if (plan.getLeft().get(i) == 1) {
                intPlanArray[i] = 1;
            }
            if (plan.getRight().get(i) == 1) {
                intPlanArray[i + 8] = 1;
            }
        }
    }

    public void showPlan() {
        System.out.print("Left: ");
        for (int i = 0; i < intPlanArray.length; i++) {
            if (i==8) {
                System.out.println("Right: ");
            }
            System.out.print(intPlanArray[i]);
        }
    }

    public int getInfo(int i) {
        return intPlanArray[i];
    }

    public int getLen() {
        return intPlanArray.length;
    }

    public void updatePlan(int pos) {
        this.intPlanArray[pos] = 2;
    }

    public boolean isLoadingFinished() {
        loadingFinished = true;
        for (int i=0; i<this.intPlanArray.length; i++ ) {
            if (this.intPlanArray[i] == 1) {
                loadingFinished = false;
                break;
            }
        }
        return loadingFinished;
    }
}
