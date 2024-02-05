package org.truck.helper;

public class Main {
    public static void main(String[] args) {
        var plan = new LoadPlanFlat();
        var list1 = plan.flatIntMap("loadingPlan.json");

        for (int i=0; i<list1.length; i++) {
            System.out.print(list1[i] + ", ");
        }
    }
}
