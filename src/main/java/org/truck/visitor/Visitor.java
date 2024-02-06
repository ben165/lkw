package org.truck.visitor;

import java.util.ArrayList;
import java.util.List;

public class Visitor {
    List<Object> damagedParts = new ArrayList<>();
    List<String> category = new ArrayList<>();

    public void addPart(Object o) {
        damagedParts.add(o);
    }

    public void addCategory(String error) {
        category.add(error);
    }

    public List<Object> getDamagedParts() {
        return damagedParts;
    }

    public List<String> getCategory() {
        return category;
    }
}
