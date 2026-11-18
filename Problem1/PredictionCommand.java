/** CONCRETE COMMAND: wraps the model-execution step. */
public class PredictionCommand implements Command {
    private final PredictionModel model; // receiver

    public PredictionCommand(PredictionModel model) {
        this.model = model;
    }

    /** Delegates the work to the receiver. */
    @Override
    public void execute() {
        model.applyPredictionModel();
    }
}
