package store.controller;

import store.model.Product;
import store.model.Stock;
import store.model.Order;
import store.view.InputView;
import store.view.OutputView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StoreController {
    public void start() throws IOException {
        InputView.displayWelcomeMessage();
        Stock stock = new Stock();
        List<Product> products = stock.getProducts();
        for (Product product : products) {
            String productName = product.getProductName();
            int price = product.getPrice();
            int quantity = product.getQuantity();
            String promotion = product.getPromotion();
            OutputView.displayStock(productName, price, quantity, promotion);
        }

        getProducts();
    }

    private void getProducts() {
        String inputProduct = InputView.readProduct();
        List<Order> orders = handleOrder(inputProduct);
        InputView.readMembership();
        OutputView.displayReceiptStart();

        for (Order order : orders) {
            String orderedProductName = order.getOrderedProductName();
            int orderedProductQuantity = order.getOrderedProductQuantity();
            int orderedProductPrice = order.getProductPrice();

            int orderedPrice = orderedProductPrice * orderedProductQuantity;
            OutputView.displayReceipt(orderedProductName, orderedProductQuantity, orderedPrice);
        }
    }

    private List<Order> handleOrder(String inputProduct) {
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

}
