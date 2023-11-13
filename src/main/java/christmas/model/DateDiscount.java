package christmas.model;

import java.util.Arrays;
import java.util.List;

public class DateDiscount {
    private static final int DISCOUNT_START_AMOUNT = 1000;
    private static final int DISCOUNT_INCREASE_AMOUNT = 100;
    private static final int DISCOUNT_START_DAY = 1;
    private static final int DISCOUNT_END_DAY = 25;
    private static final List<Integer> WEEKEND_DAYS = Arrays.asList(1, 2, 8, 9, 15, 16, 22, 23, 29, 30);


    public static int dayDiscount(int date) {
        int totalDiscount = 0;
        if (DISCOUNT_START_DAY <= date && date <= DISCOUNT_END_DAY) {
            totalDiscount = DISCOUNT_START_AMOUNT + (date - DISCOUNT_START_DAY) * DISCOUNT_INCREASE_AMOUNT;
            return totalDiscount;
        }
        return totalDiscount;
    }

    public static int weekendDayDiscount(int date, List<String> menus) {
        int totalDiscount = 0;
        if (WEEKEND_DAYS.contains(date)) {
            for (String menu : menus) {
                String[] menuInfo = menu.split("-");
                String menuName = menuInfo[0];
                int quantity = Integer.parseInt(menuInfo[1]);

                if (isMainMenu(menuName)) {
                    totalDiscount += quantity * 2023;
                }
            }
        }
        return totalDiscount;
    }

    public static int weekDayDiscount(int date, List<String> menus) {
        int totalDiscount = 0;
        if (!WEEKEND_DAYS.contains(date)) {
            for (String menu : menus) {
                String[] menuInfo = menu.split("-");
                String menuName = menuInfo[0];
                int quantity = Integer.parseInt(menuInfo[1]);

                if (isDessertMenu(menuName)) {
                    totalDiscount += quantity * 2023;
                }
            }
        }
        return totalDiscount;
    }

    private static boolean isMainMenu(String menuName) {
        return Arrays.asList("티본스테이크", "바비큐립", "해산물파스타", "크리스마스파스타").contains(menuName);
    }

    private static boolean isDessertMenu(String menuName) {
        return Arrays.asList("초코케이크", "아이스크림").contains(menuName);
    }
}
