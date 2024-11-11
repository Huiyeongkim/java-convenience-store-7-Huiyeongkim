package store.model;

import java.io.IOException;
import java.time.LocalDate;

public class Promotion {
    private static String promotionName;
    private static int buyQuantity;
    private static int freeQuantity;
    private static LocalDate startDate;
    private static LocalDate endDate;

    public Promotion(String promotionName, int buyQuantity, int freeQuantity, String startDate, String endDate) throws IOException {
        this.promotionName = promotionName;
        this.buyQuantity = buyQuantity;
        this.freeQuantity = freeQuantity;
        this.startDate = LocalDate.parse(startDate);
        this.endDate = LocalDate.parse(endDate);
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public boolean isPromotionValid(LocalDate currentDate) {
        return !currentDate.isBefore(startDate) && !currentDate.isAfter(endDate);
    }
}
