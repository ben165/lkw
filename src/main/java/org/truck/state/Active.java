package org.truck.state;

public class Active implements IState{
    @Override
    public void change(State state) {
        System.out.println("inactive -> active");
        state.setState(new Inactive());
    }

    public void print() {
        System.out.println("Active");
    }

    public String toString() {
        return "inactive";
    }
}
