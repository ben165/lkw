package org.truck.helper;

import org.truck.entity.LoadingScheme;

public class Main {
    public static void main(String[] args) {
        LoadingScheme l = Json.readParameters();

        System.out.println("left: " + l.getLeft());
        System.out.println("right: " + l.getRight());

    }
}
