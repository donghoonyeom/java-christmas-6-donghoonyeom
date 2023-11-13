package christmas.model;


public class TotalDiscountCalculator {


    public static int calculateGiftMenu(int totalOrderAmount, int totalDiscount) {
        int totalBenefits = totalDiscount;
        if (totalOrderAmount >= 120000) {
            totalBenefits += getGiftMenuPrice();
        }
        return totalBenefits;
    }

    public static int printGiftMenu(int totalOrderAmount) {
        if (totalOrderAmount >= 120000) {
            return getGiftMenuPrice();
        }
        return 0;
    }

    private static int getGiftMenuPrice() {
        return Menu.샴페인.getPrice();
    }
}
