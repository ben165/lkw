package org.truck.state;

public class State{
    private IState state;

    public IState getState() {
        return state;
    }

    public void setState(IState state) {
        this.state = state;
    }

    public void promote() {
        state.change(this);
    }

    public String toString() {
        return "{ state = " + state + " }";
    }

}
