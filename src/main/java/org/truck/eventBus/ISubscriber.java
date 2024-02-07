package org.truck.eventBus;

public interface ISubscriber {
    void trigger(int code);
}
