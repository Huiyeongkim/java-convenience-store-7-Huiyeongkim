package store.controller;

import store.model.Product;
import store.model.Stock;
import store.view.InputView;
import store.view.OutputView;

import java.io.IOException;
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


    }

}
