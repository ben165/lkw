package org.truck.state;

public class Inactive implements IState{
    public void change(State state) {
        System.out.println("inactive -> active");
        state.setState(new Active());
    }

    @Override
    public boolean stateAsBoolean() {
        return false;
    }

}
