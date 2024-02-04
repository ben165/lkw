package org.truck.observer;

import org.truck.vehicle.Trailer;

public interface ITrailerListener {
    boolean trailerDetected(Trailer trailer);
}
