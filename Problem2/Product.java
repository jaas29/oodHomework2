/** COMPOSITE PATTERN - leaf: a single item such as "Laptop". */
public class Product extends ProductComponent {
    private final String name;
    private final double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void display() {
        System.out.printf("Product: %s, Price: $%.2f%n", name, price);
    }
}
