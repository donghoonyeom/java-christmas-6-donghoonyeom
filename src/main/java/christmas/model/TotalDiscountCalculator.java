package christmas.model;

import java.util.Set;

public class TotalDiscountCalculator {

    private static final int GIFT_MENU_ORDER_AMOUNT_THRESHOLD = 120000;
    private static final int DEFAULT_DISCOUNT = 0;

    public static int calculateDateDiscount(int date, Set<OrderItem> menus) {
        int dateDiscount = DateDiscount.ddayDiscount(date);
        int weekDayDiscount = WeekendWeekdayDiscount.weekDayDiscount(date, menus);
        int weekendDayDiscount = WeekendWeekdayDiscount.weekendDayDiscount(date, menus);
        return dateDiscount + weekDayDiscount + weekendDayDiscount;
    }

    public static int calculateStarDiscount(int date) {
        return StarDiscount.starDayDiscount(date);
    }

    public static int calculateGiftMenu(int totalOrderAmount, int totalDiscount) {
        int totalBenefits = totalDiscount;
        if (totalOrderAmount >= GIFT_MENU_ORDER_AMOUNT_THRESHOLD) {
            totalBenefits += getGiftMenuPrice();
        }
        return totalBenefits;
    }

    public static int printGiftMenuPrice(int totalOrderAmount) {
        if (totalOrderAmount < GIFT_MENU_ORDER_AMOUNT_THRESHOLD) {
            return DEFAULT_DISCOUNT;
        }
        return getGiftMenuPrice();
    }

    private static int getGiftMenuPrice() {
        return Menu.getChampagnePrice();
    }
}
