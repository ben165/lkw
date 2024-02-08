package org.truck.trailerParts.mediator;

public interface ITrailerMediator {
    void indicateOff();

    void indicateRight();

    void indicateLeft();

    void brakeLights(boolean status);

    void brake(int percentage);
}
