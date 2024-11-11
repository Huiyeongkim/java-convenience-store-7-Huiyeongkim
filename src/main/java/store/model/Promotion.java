package store.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Promotion {
    private static final String promotionsFile = "src/main/resources/promotion.md";

    private static String promotionName;
    private static int buyQuantity;
    private static int freeQuantity;
    private static String startDate;
    private static String endDate;

    private static List<Promotion> promotions = new ArrayList<>();

    public Promotion(String promotionName, int buyQuantity, int freeQuantity, String startDate, String endDate) throws IOException {
        this.promotionName = promotionName;
        this.buyQuantity = buyQuantity;
        this.freeQuantity = freeQuantity;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public static void readPromotionsFile() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(promotionsFile));
        bufferedReader.readLine();

        String line;
        while (true) {
            line = bufferedReader.readLine();
            if (line == null) {
                bufferedReader.close();
                break;
            }
            promotions.add(splitLine(line));
        }
    }

    private static Promotion splitLine(String line) throws IOException {
        String[] str = line.split(",");
        String promotionName = str[0];
        int buyQuantity = Integer.parseInt(str[1]);
        int freeQuantity = Integer.parseInt(str[2]);
        String startDate = str[3];
        String endDate = str[4];

        return new Promotion(promotionName, buyQuantity, freeQuantity, startDate, endDate);
    }

    public List<Promotion> getPromotions() {
        return promotions;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public int getBuyQuantity() {
        return buyQuantity;
    }

    public int getFreeQuantity() {
        return freeQuantity;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }
}
