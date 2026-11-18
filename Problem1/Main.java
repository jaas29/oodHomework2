/**
 * CLIENT. Demonstrates both patterns:
 *  1) Template Method - each strategy runs the same 4-step workflow.
 *  2) Command - tasks are queued in an invoker and executed in sequence.
 */
public class Main {
    public static void main(String[] args) {
        // ---------- Template Method ----------
        System.out.println("=== Statistical Prediction ===");
        HurricanePredictionTemplate statistical = new StatisticalPrediction();
        statistical.predictHurricane();

        System.out.println("\n=== Machine Learning Prediction ===");
        HurricanePredictionTemplate ml = new MachineLearningPrediction();
        ml.predictHurricane();

        // ---------- Command ----------
        System.out.println("\n=== Task Manager (Command Pattern) ===");
        // Receivers
        WeatherDataFetcher fetcher = new WeatherDataFetcher();
        PredictionModel model = new PredictionModel();
        ResultSaver saver = new ResultSaver();

        // Commands wrap receivers; the invoker runs them in order
        PredictionInvoker invoker = new PredictionInvoker();
        invoker.addCommand(new FetchDataCommand(fetcher));
        invoker.addCommand(new PredictionCommand(model));
        invoker.addCommand(new SaveResultsCommand(saver));
        invoker.executeCommands();
    }
}
