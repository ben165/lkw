package org.truck.cor2;

public class Checker {
    private Checker successor;

    public void parse(String fileName) {
        if (getSuccessor() != null) {
            getSuccessor().parse(fileName);
        } else {
            System.out.println("unable to find correct parser : " + fileName);
        }
    }

    protected boolean canHandleFile(String fileName, String format) {
        return (fileName == null) || (fileName.endsWith(format));
    }

    public Checker getSuccessor() {
        return successor;
    }

    public void setSuccessor(Checker successor) {
        this.successor = successor;
    }
}
