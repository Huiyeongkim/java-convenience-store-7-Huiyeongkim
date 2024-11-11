package store.view;

public class OutputView {
    private final static String receipt = "==============W 편의점================\n" + "상품명\t\t수량\t금액";
    private final static String giveaway = "=============증\t정===============";

    public static void displayStock(String productName, int price, int quantity, String promotion) {
        System.out.print("- " + productName + " " + price + "원 " + quantity + "개");
        if (!promotion.equals("null")) {
            System.out.print(" " + promotion);
        }
        System.out.println();
    }

    public static void displayReceiptStart() {
        System.out.println();
        System.out.println(receipt);
    }

    public static void displayReceipt(String orderedProductName, int orderedProductQuantity, int orderedPrice) {
        System.out.println(orderedProductName + "\t\t" + orderedProductQuantity + "\t" + orderedPrice);
    }

    public static void displayGiveawayStart() {
        System.out.println(giveaway);
    }

    public static void displayGiveaway(String promotionProductName, int promotionProductQuantity) {
        System.out.println(promotionProductName + "\t\t" + promotionProductQuantity);
    }

}
