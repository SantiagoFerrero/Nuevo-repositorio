package command;

import java.util.ArrayList;
import java.util.List;

public class Invoker {
    private List<Command> commands = new ArrayList<>();

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void ejecutarCommands() {
        for (Command command : commands) {
            command.ejecutar();
        }
        commands.clear();
    }
}