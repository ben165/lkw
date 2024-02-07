package org.truck.eventBus;

public interface ISubscriber {
    void trigger(EventMsg msg);
}
