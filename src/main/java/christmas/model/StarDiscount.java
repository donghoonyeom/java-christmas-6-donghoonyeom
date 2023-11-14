package christmas.model;

import java.util.Arrays;
import java.util.List;

public class StarDiscount {
    private static final List<Integer> STAR_DAYS = Arrays.asList(3, 10, 17, 18, 24, 25, 31);
    private static final int STAR_DISCOUNT = 1000;
    private static final int DEFAULT_DISCOUNT = 0;

    public static int starDayDiscount(int date) {
        if (STAR_DAYS.contains(date)) {
            return STAR_DISCOUNT;
        }
        return DEFAULT_DISCOUNT;
    }
}
