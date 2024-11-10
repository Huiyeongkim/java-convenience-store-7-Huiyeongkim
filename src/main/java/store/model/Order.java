package store.model;

public class Order {
    private final String orderedProductName;
    private final int orderedProductQuantity;

    public Order(String orderedProductName, int orderedProductQuantity) {
        this.orderedProductName = orderedProductName;
        this.orderedProductQuantity = orderedProductQuantity;
    }

    public int getProductPrice() {
        Product product = Stock.findProductByName(orderedProductName);
        if (product == null) {
            return 0;
        }
        return product.getPrice();
    }

    public String getOrderedProductName() {
        return orderedProductName;
    }

    public int getOrderedProductQuantity() {
        return orderedProductQuantity;
    }
}
