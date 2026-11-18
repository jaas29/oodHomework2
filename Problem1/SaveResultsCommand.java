/** CONCRETE COMMAND: wraps the result-saving step. */
public class SaveResultsCommand implements Command {
    private final ResultSaver saver; // receiver

    public SaveResultsCommand(ResultSaver saver) {
        this.saver = saver;
    }

    /** Delegates the work to the receiver. */
    @Override
    public void execute() {
        saver.saveResults();
    }
}
