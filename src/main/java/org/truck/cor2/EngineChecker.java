package org.truck.cor2;

public class EngineChecker extends Checker {
    public void parse(String fileName) {
        if (canHandleFile(fileName, ".xml")) {
            System.out.println("xml parser : " + fileName);
        } else {
            super.parse(fileName);
        }
    }
}

