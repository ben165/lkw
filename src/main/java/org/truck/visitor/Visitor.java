package org.truck.visitor;

import java.util.ArrayList;
import java.util.List;

public class Visitor {
    List<Object> damagedParts = new ArrayList<>();
    List<String> category = new ArrayList<>();

    public void addPart(Object o) {
        damagedParts.add(o);
    }

    public void addCategory(Object o) {
        damagedParts.add(o);
    }
}
