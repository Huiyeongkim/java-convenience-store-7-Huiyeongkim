package store.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Stock {
    private static final String file = "src/main/resources/products.md";
    private static List<Product> products;

    public Stock() throws IOException {
        products = new ArrayList<>();
        Promotion.readPromotionsFile();
        readProductsFile(products);
    }

    public static Product findProductByName(String orderedProductName) {
        for (Product product : products) {
            if (product.getProductName().equals(orderedProductName)) {
                return product;
            }
        }
        return null;
    }

    private void readProductsFile(List<Product> products) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        bufferedReader.readLine();

        String line;
        while (true) {
            line = bufferedReader.readLine();
            if (line == null) {
                bufferedReader.close();
                break;
            }
            products.add(splitLine(line));
        }
    }
    private Product splitLine(String line) {
        String[] str = line.split(",");
        String name = str[0];
        int price = Integer.parseInt(str[1]);
        int quantity = Integer.parseInt(str[2]);
        String promotion = str[3];

        return new Product(name, price, quantity, promotion);
    }

    public List<Product> getProducts() {
        return products;
    }


}
