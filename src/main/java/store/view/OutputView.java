package store.view;

public class OutputView {

    public static void displayStock(String productName, int price, int quantity, String promotion) {
        System.out.print("- " + productName + " " + price + "원 " + quantity + "개");
        if (!promotion.equals("null")) {
            System.out.print(" " + promotion);
        }
        System.out.println();
    }


}
