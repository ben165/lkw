package org.truck.cor;

public interface IChecker {
    boolean canHandlePart(Object part);
    void check(Object part);
}
