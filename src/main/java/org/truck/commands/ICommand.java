package org.truck.commands;

public interface ICommand {
    void execute();
    void execute(int nr1);
    void execute (int nr1, int nr2);
}
