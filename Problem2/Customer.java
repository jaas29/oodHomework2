/** OBSERVER PATTERN - concrete observer. */
public class Customer implements DealObserver {
    private final String name;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /** Called by BlackFridayDeals when a new deal is announced. */
    @Override
    public void receiveNotification(String deal) {
        System.out.println("Dear " + name + ", New deal available! " + deal);
    }
}
