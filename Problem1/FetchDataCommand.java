/** CONCRETE COMMAND: wraps the data-retrieval step. */
public class FetchDataCommand implements Command {
    private final WeatherDataFetcher fetcher; // receiver

    public FetchDataCommand(WeatherDataFetcher fetcher) {
        this.fetcher = fetcher;
    }

    /** Delegates the work to the receiver. */
    @Override
    public void execute() {
        fetcher.fetchData();
    }
}
