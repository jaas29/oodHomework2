# HW2 Problem 2 - Black Friday Shopping Application

## Run
```sh
sh run.sh
```
Output is saved in `sample-output.txt` and matches the handout's sample output line for line. UML: `uml.png`.

## Design patterns used and why

The handout says "2 design patterns are used" without naming them. They are:

**Composite** (Part 1: `ProductComponent`, `Product`, `Category`)
- `ProductComponent` is the common abstract type. `Product` is the leaf, `Category` is the composite that holds a `List<ProductComponent>`.
- Because a `Category` stores `ProductComponent`, it can contain Products *and* other Categories ("Black Friday Deals" contains "Electronics" and "Clothing").
- `Category.display()` prints its name, then calls `display()` on each child. The recursion walks the whole tree without checking types.
- Why: the client treats one product and a whole category the same way (`display()`, `getPrice()`).

**Observer** (Part 2: `BlackFridayDeals`, `DealObserver`, `Customer`)
- `BlackFridayDeals` is the subject. It keeps a list of subscribers and `notifyCustomers(deal)` loops over them.
- `Customer` implements `DealObserver.receiveNotification(deal)`.
- Why: deals are pushed to whoever subscribed. Subjects do not know concrete customer details, and customers can subscribe or unsubscribe at runtime.

## Test case (from the handout)
- V and JK subscribe and receive the deal.
- Jimin never subscribes, so `notifyCustomers` skips them; `checkSubscription(jimin)` prints
  `Customer Jimin is not subscribed to deal notifications.`

## Design notes
- `add()` is declared in `ProductComponent` with a default that throws `UnsupportedOperationException`, so leaves refuse children. This is the "transparent" Composite. Declaring `add()` only in `Category` ("safe" Composite) is also acceptable.
- `Category.getPrice()` returns the sum of its children. The handout does not require a category price; returning 0 is fine too.
- The `DealObserver` interface is not required by the handout (it only names `Customer`), but it keeps the subject depending on an abstraction, the same way the course's `StockObserver` example does.

## Resources
- Course Week 7 Observer example: https://github.com/OOD-NCF/Week7_Observer_2025
- Composite pattern reference: https://refactoring.guru/design-patterns/composite
