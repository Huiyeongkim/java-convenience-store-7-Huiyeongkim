package store.controller;

import store.model.*;
import store.view.InputView;
import store.view.OutputView;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StoreController {
    public void start() throws IOException {
        InputView.displayWelcomeMessage();
        ProductManager productManager = new ProductManager();
        PromotionManager promotionManager = new PromotionManager();

        List<Product> products = productManager.getProducts();
        for (Product product : products) {
            String productName = product.getProductName();
            int price = product.getPrice();
            int quantity = product.getQuantity();
            String promotion = product.getPromotion();
            OutputView.displayStock(productName, price, quantity, promotion);
        }

        getProducts(promotionManager);
    }

    private void getProducts(PromotionManager promotionManager) {
        String inputProduct = InputView.readProduct();
        List<Order> orders = handleOrder(inputProduct, promotionManager);
        InputView.readMembership();
        OutputView.displayReceiptStart();

        for (Order order : orders) {
            String orderedProductName = order.getOrderedProductName();
            int orderedProductQuantity = order.getOrderedProductQuantity();
            int orderedProductPrice = order.getProductPrice();

            int orderedPrice = orderedProductPrice * orderedProductQuantity;
            OutputView.displayReceipt(orderedProductName, orderedProductQuantity, orderedPrice);
        }

        getPromotions(orders);
    }

    private List<Order> handleOrder(String inputProduct, PromotionManager promotionManager) {
        String[] tokens = inputProduct.split(",");
        List<Order> orders = new ArrayList<>();
        for (String token : tokens) {
            token = token.trim();
            String s = token.replaceAll("[\\[\\]]", "");
            String[] split = s.split("-");
            String orderedProductName = split[0].trim();
            int orderedProductQuantity = Integer.parseInt(split[1].trim());

            orders.add(new Order(orderedProductName, orderedProductQuantity));
        }
        return orders;

    }

    private void getPromotions(List<Order> orders) {
        OutputView.displayGiveawayStart();
        LocalDate currentDate = LocalDate.now();

        for (Order order : orders) {
            if (order.isPromotionProduct(currentDate)) {
                String promotionProductName = order.getOrderedProductName();
                int promotionProductQuantity = order.getOrderedPromotionQuantity();
                OutputView.displayGiveaway(promotionProductName, promotionProductQuantity);
            }
        }
    }
}
