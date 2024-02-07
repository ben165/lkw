package org.truck.eventBus;

import java.util.ArrayList;
import java.util.List;

public interface IPublisher {
    List<Event> listener = new ArrayList<>();
    void addListener(Event e);
    void removeAll();
    void send(int code);
}
