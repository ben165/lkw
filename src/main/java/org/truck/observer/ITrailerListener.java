package org.truck.observer;

import org.truck.vehicle.Trailer;

public interface ITrailerListener {
    void trailerDetected(Trailer trailer);
}
