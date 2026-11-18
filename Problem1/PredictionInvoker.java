import java.util.ArrayList;
import java.util.List;

/**
 * INVOKER (the "task manager"). Stores commands and runs them in order.
 * It only knows the Command interface - never the receivers.
 */
public class PredictionInvoker {
    private final List<Command> commands = new ArrayList<>();

    /** Adds a task to the end of the queue. */
    public void addCommand(Command command) {
        commands.add(command);
    }

    /** Removes a task (shows steps can be managed independently). */
    public void removeCommand(Command command) {
        commands.remove(command);
    }

    /** Executes every command in the order it was added. */
    public void executeCommands() {
        for (Command command : commands) {
            command.execute();
        }
    }
}
