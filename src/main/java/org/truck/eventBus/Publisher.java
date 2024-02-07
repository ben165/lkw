package org.truck.eventBus;

public class Publisher implements IPublisher{
    @Override
    public void addListener(Event e) {
        listener.add(e);
    }

    @Override
    public void removeAllListener() {
        listener.clear();
    }

    @Override
    public void send(EventMsg msg) {
        for (int i=0; i< listener.size(); i++) {
            listener.get(i).trigger(msg);
        }
    }
}
