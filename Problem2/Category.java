import java.util.ArrayList;
import java.util.List;

/**
 * COMPOSITE PATTERN - composite: a group such as "Electronics".
 * Holds Products AND other Categories (any ProductComponent).
 */
public class Category extends ProductComponent {
    private final String name;
    private final List<ProductComponent> children = new ArrayList<>();

    public Category(String name) {
        this.name = name;
    }

    /** Adds a product or a sub-category. */
    @Override
    public void add(ProductComponent component) {
        children.add(component);
    }

    @Override
    public String getName() {
        return name;
    }

    /** A category's price is the total of everything inside it (recursive). */
    @Override
    public double getPrice() {
        double total = 0;
        for (ProductComponent child : children) {
            total += child.getPrice();
        }
        return total;
    }

    /** Prints the category name, then asks each child to display itself. */
    @Override
    public void display() {
        System.out.println("Category: " + name);
        for (ProductComponent child : children) {
            child.display(); // works for both Product and Category
        }
    }
}
