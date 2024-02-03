package org.truck.state;

public interface IState {
    void change(State state);
    void print();
}
