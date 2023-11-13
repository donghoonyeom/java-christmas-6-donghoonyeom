package christmas.model;


public class DateDiscount {
    private static final int DISCOUNT_START_AMOUNT = 1000;
    private static final int DISCOUNT_INCREASE_AMOUNT = 100;
    private static final int DISCOUNT_START_DAY = 1;
    private static final int DISCOUNT_END_DAY = 25;



    public static int dayDiscount(int date) {
        int totalDiscount = 0;
        if (DISCOUNT_START_DAY <= date && date <= DISCOUNT_END_DAY) {
            totalDiscount = DISCOUNT_START_AMOUNT + (date - DISCOUNT_START_DAY) * DISCOUNT_INCREASE_AMOUNT;
            return totalDiscount;
        }
        return totalDiscount;
    }

}

