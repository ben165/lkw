package org.truck.helper;
import java.util.Random;
public class Rand {
    static Random r = new Random();
    static String[] errorStr = {"E01", "E02", "E03"};
    public static double rand() {
        return r.nextDouble();
    }

    public static String randError() {
        return errorStr[r.nextInt(3)];
    }
}
