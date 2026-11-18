/**
 * TEMPLATE METHOD PATTERN - abstract class.
 * Fixes the ORDER of the prediction workflow in predictHurricane().
 * Subclasses decide HOW each step is done, but they can never change the order.
 */
public abstract class HurricanePredictionTemplate {

    /**
     * The template method. It is final so no subclass can reorder or skip steps.
     */
    public final void predictHurricane() {
        fetchData();
        preprocessData();
        applyPredictionModel();
        postprocessResults();
    }

    /** Step 1: retrieve the data the model needs. */
    protected abstract void fetchData();

    /** Step 2: clean / prepare the data for the model. */
    protected abstract void preprocessData();

    /** Step 3: run the prediction model. */
    protected abstract void applyPredictionModel();

    /** Step 4: process and save the results. */
    protected abstract void postprocessResults();
}
