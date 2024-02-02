package org.truck.parts;

public class Brakelight {
    boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
        System.out.println("Brakelight: " + this.hashCode() + " Status: " + status);
    }
}
