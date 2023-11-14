package christmas.model;

public class DateDiscount {
    private static final int DISCOUNT_START_AMOUNT = 1000;
    private static final int DISCOUNT_INCREASE_AMOUNT = 100;
    private static final int DISCOUNT_START_DAY = 1;
    private static final int DISCOUNT_END_DAY = 25;
    private static final int DEFAULT_DISCOUNT = 0;

    public static int ddayDiscount(int date) {
        if (isDiscountDay(date)) {
            return calculateDayDiscount(date);
        }
        return DEFAULT_DISCOUNT;
    }

    private static boolean isDiscountDay(int date) {
        return DISCOUNT_START_DAY <= date && date <= DISCOUNT_END_DAY;
    }

    private static int calculateDayDiscount(int date) {
        return DISCOUNT_START_AMOUNT + (date - DISCOUNT_START_DAY) * DISCOUNT_INCREASE_AMOUNT;
    }
}
