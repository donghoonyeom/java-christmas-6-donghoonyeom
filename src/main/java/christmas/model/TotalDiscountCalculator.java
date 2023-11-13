package christmas.model;

import java.util.List;

public class TotalDiscountCalculator {

    public static int calculateDateDiscount(int date, List<String> menus) {
        int dateDiscount = DateDiscount.dayDiscount(date);
        int weekDayDiscount = DateDiscount.weekDayDiscount(date, menus);
        int weekendDayDiscount = DateDiscount.weekendDayDiscount(date, menus);

        return dateDiscount + weekDayDiscount + weekendDayDiscount;
    }


    public static int calculateStarDiscount(int date) {
        return StarDiscount.starDayDiscount(date);
    }

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
