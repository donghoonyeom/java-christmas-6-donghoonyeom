package christmas.model;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class WeekendWeekdayDiscount {
    private static final int WEEKDAY_WEEKEND_DISCOUNT = 2023;
    private static final int DEFAULT_DISCOUNT = 0;
    private static final List<Integer> WEEKEND_DAYS = Arrays.asList(1, 2, 8, 9, 15, 16, 22, 23, 29, 30);

    public static int weekendDayDiscount(int date, Set<OrderItem> menus) {
        if (isWeekendDay(date)) {
            return calculateWeekendDayDiscount(menus);
        }
        return DEFAULT_DISCOUNT;
    }

    public static int weekDayDiscount(int date, Set<OrderItem> menus) {
        if (!isWeekendDay(date)) {
            return calculateWeekDayDiscount(menus);
        }
        return DEFAULT_DISCOUNT;
    }

    private static boolean isWeekendDay(int date) {
        return WEEKEND_DAYS.contains(date);
    }

    private static int calculateWeekendDayDiscount(Set<OrderItem> menus) {
        return calculateDiscountForMenus(menus, WeekendWeekdayDiscount::isMainMenu);
    }

    private static int calculateWeekDayDiscount(Set<OrderItem> menus) {
        return calculateDiscountForMenus(menus, WeekendWeekdayDiscount::isDessertMenu);
    }

    private static int calculateDiscountForMenus(Set<OrderItem> menus, MenuPredicate menuPredicate) {
        return menus.stream()
                .filter(orderItem -> menuPredicate.test(orderItem.getMenuName()))
                .mapToInt(WeekendWeekdayDiscount::calculateDiscountForMenu)
                .sum();
    }

    private static int calculateDiscountForMenu(OrderItem orderItem) {
        int quantity = orderItem.getQuantity();
        return quantity * WEEKDAY_WEEKEND_DISCOUNT;
    }

    private static boolean isMainMenu(String menuName) {
        return Menu.valueOf(menuName).containsMainMenu(menuName);
    }

    private static boolean isDessertMenu(String menuName) {
        return Menu.valueOf(menuName).containsDessertMenu(menuName);
    }

    private interface MenuPredicate {
        boolean test(String menuName);
    }
}
