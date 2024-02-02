package org.truck.commands;

public class Control {
    private ICommand command;

    public void setCommand(ICommand command) {
        this.command = command;
    }

    public void action() {
        // je nach dem...
        command.execute();
    }

    public void action(int nr1) {
        command.execute(nr1);
    }

    public void action(int nr1,int nr2) {
        command.execute(nr1, nr2);
    }

}
