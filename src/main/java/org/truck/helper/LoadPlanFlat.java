package org.truck.helper;

import org.truck.entity.LoadingScheme;

public class LoadPlanFlat {
    private final int[] intPlanArray = new int[16];

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
        for (int i=0; i<intPlanArray.length; i++) {
            System.out.print(intPlanArray[i]);
        }
    }

    public int getInfo(int i) {
        return intPlanArray[i];
    }

    public int getLen() {
        return intPlanArray.length;
    }
}
