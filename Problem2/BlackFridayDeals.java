import java.util.ArrayList;
import java.util.List;

/**
 * OBSERVER PATTERN - subject.
 * Keeps the list of subscribed customers and pushes deals to them.
 */
public class BlackFridayDeals {
    private final List<DealObserver> subscribers = new ArrayList<>();

    public void subscribe(DealObserver customer) {
        subscribers.add(customer);
    }

    public void unsubscribe(DealObserver customer) {
        subscribers.remove(customer);
    }

    public boolean isSubscribed(DealObserver customer) {
        return subscribers.contains(customer);
    }

    /** Sends the deal to every subscribed customer (and only them). */
    public void notifyCustomers(String deal) {
        for (DealObserver subscriber : subscribers) {
            subscriber.receiveNotification(deal);
        }
    }

    /** Used by the test case: reports a customer who will NOT get deals. */
    public void checkSubscription(Customer customer) {
        if (!isSubscribed(customer)) {
            System.out.println("Customer " + customer.getName()
                    + " is not subscribed to deal notifications.");
        }
    }
}
