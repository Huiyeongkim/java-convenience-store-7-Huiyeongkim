package store.model;

import java.time.LocalDate;

public class Order {
    private final String orderedProductName;
    private final int orderedProductQuantity;

    public Order(String orderedProductName, int orderedProductQuantity) {
        this.orderedProductName = orderedProductName;
        this.orderedProductQuantity = orderedProductQuantity;
    }

    public int getProductPrice() {
        Product product = ProductManager.findProductByName(orderedProductName);
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

    public Promotion findPromotion() {
        Product product = ProductManager.findPromotionProductByName(orderedProductName);
        if (product == null) {
            return null;
        }
        return PromotionManager.findPromotionByPromotionName(product.getPromotion());
    }

    public boolean isPromotionProduct(LocalDate currentDate) {
        Product product = ProductManager.findPromotionProductByName(orderedProductName);
        if (product == null) {
            return false;
        }
        return findPromotion().isPromotionValid(currentDate);
    }

    public int getOrderedPromotionQuantity() {
        Product product = ProductManager.findPromotionProductByName(orderedProductName);
        if (product==null) {
            return 0;
        }
        Promotion promotion = PromotionManager.findPromotionByPromotionName(product.getPromotion());
        if (promotion==null) {
            return 0;
        }

        return (orderedProductQuantity / (promotion.getBuyQuantity() + promotion.getFreeQuantity()))*promotion.getFreeQuantity();
    }
}
