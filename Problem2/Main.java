/**
 * CLIENT. Builds the catalog tree (Composite) and sends deals (Observer).
 * Test case: two subscribed customers and one NOT subscribed customer.
 */
public class Main {
    public static void main(String[] args) {
        // ---------- Part 1: Composite ----------
        Category electronics = new Category("Electronics");
        electronics.add(new Product("Laptop", 799.99));
        electronics.add(new Product("Smartphone", 499.99));
        electronics.add(new Product("Headphones", 99.99));

        Category clothing = new Category("Clothing");
        clothing.add(new Product("Jacket", 59.99));

        Category blackFriday = new Category("Black Friday Deals");
        blackFriday.add(electronics); // a category inside a category
        blackFriday.add(clothing);

        System.out.println("Product Catalog:");
        blackFriday.display();

        // ---------- Part 2: Observer ----------
        BlackFridayDeals deals = new BlackFridayDeals();
        Customer v = new Customer("V");
        Customer jk = new Customer("JK");
        Customer jimin = new Customer("Jimin"); // never subscribes

        deals.subscribe(v);
        deals.subscribe(jk);

        System.out.println("\nNotifying customers about a deal:");
        deals.notifyCustomers("Huge discounts on Electronics!");
        deals.checkSubscription(jimin);
    }
}
