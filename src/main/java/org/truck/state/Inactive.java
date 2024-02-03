package org.truck.state;

public class Inactive implements IState{
    public void change(State state) {
        System.out.println("active -> inactive");
        state.setState(new Active());
    }

    public void print() {
        System.out.println("Inactive");
    }

    public String toString() {
        return "active";
    }

}
