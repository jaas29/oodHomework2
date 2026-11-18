/**
 * Concrete template step implementation: machine-learning model that uses
 * HISTORICAL + REAL-TIME data.
 */
public class MachineLearningPrediction extends HurricanePredictionTemplate {

    @Override
    protected void fetchData() {
        System.out.println("Fetching historical and real-time satellite data for ML model.");
    }

    @Override
    protected void preprocessData() {
        System.out.println("Normalizing data and extracting features for ML model.");
    }

    @Override
    protected void applyPredictionModel() {
        System.out.println("Running trained machine learning model for hurricane prediction.");
    }

    @Override
    protected void postprocessResults() {
        System.out.println("Evaluating ML confidence scores and storing predictions.");
    }
}
