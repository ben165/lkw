package org.truck.state;

public class Active implements IState {
    @Override
    public void change(State state) {
        //System.out.println("active -> inactive");
        state.setState(new Inactive());
    }

    @Override
    public boolean stateAsBoolean() {
        return true;
    }

}
