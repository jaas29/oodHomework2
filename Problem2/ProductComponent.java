/**
 * COMPOSITE PATTERN - component.
 * Common type for BOTH a single Product (leaf) and a Category (composite),
 * so client code can treat them the same way.
 */
public abstract class ProductComponent {

    public abstract String getName();

    public abstract double getPrice();

    /** Prints this component (and, for a category, everything inside it). */
    public abstract void display();

    /**
     * Only categories can hold children. Leaves inherit this default,
     * which refuses the operation.
     */
    public void add(ProductComponent component) {
        throw new UnsupportedOperationException("Cannot add to " + getName());
    }
}
