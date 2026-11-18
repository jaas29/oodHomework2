/**
 * Concrete template step implementation: statistical model that uses
 * HISTORICAL data only.
 */
public class StatisticalPrediction extends HurricanePredictionTemplate {

    @Override
    protected void fetchData() {
        System.out.println("Fetching historical weather data for statistical analysis.");
    }

    @Override
    protected void preprocessData() {
        System.out.println("Cleaning and structuring data for statistical model.");
    }

    @Override
    protected void applyPredictionModel() {
        System.out.println("Applying statistical model for hurricane prediction.");
    }

    @Override
    protected void postprocessResults() {
        System.out.println("Interpreting and formatting statistical model results.");
    }
}
