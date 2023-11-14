package christmas.validator;

import christmas.model.Menu;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public class OrderValidator {

    private static final int MAX_MENU_COUNT = 20;
    private static final String MENU_REGEX = "^[가-힣]+-[1-9]\\d*$";
    private static final String ENGLISH_REGEX = ".*[a-zA-Z]+.*";

    public static String validateAndGetOrder(String order) {
        validateOrder(order);
        return order;
    }

    private static void validateOrder(String order) {
        validateOrderCommaFormat(order);
        validateOrderFormat(order);
        validateNoEnglishCharacters(order);
        validateNoBeverageOnlyOrder(order);
        validateMenusExist(order);
    }

    private static void validateNoBeverageOnlyOrder(String order) {
        if (containsBeverageOnly(order)) {
            throw new IllegalArgumentException(ErrorMessage.BEVERAGE_ONLY_ORDER.getMessage());
        }
    }

    private static boolean containsBeverageOnly(String order) {
        return allMatch(order, menuInfo -> isBeverageMenu(menuInfo.split("-")[0].trim()));
    }

    private static boolean isBeverageMenu(String menuName) {
        return Menu.valueOf(menuName).containsBeverageMenu(menuName);
    }

    private static void validateOrderFormat(String order) {
        if (!allMatch(order, OrderValidator::isValidMenuEntryFormat)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());
        }
    }

    private static void validateOrderCommaFormat(String order) {
        if (order.startsWith(",") || order.endsWith(",")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());
        }
    }

    private static boolean allMatch(String order, Predicate<String> predicate) {
        return Arrays.stream(order.split(",")).allMatch(predicate);
    }

    private static boolean isValidMenuEntryFormat(String menuEntry) {
        return menuEntry.matches(MENU_REGEX);
    }

    private static void validateNoEnglishCharacters(String order) {
        if (containsEnglish(order)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());
        }
    }

    private static boolean containsEnglish(String order) {
        return order.matches(ENGLISH_REGEX);
    }

    private static void validateMenusExist(String order) {
        Set<String> uniqueMenus = checkForDuplicateMenus(order);
        validateTotalMenuCount(order, uniqueMenus.size());
    }

    private static Set<String> checkForDuplicateMenus(String order) {
        Set<String> uniqueMenus = new HashSet<>();

        allMatch(order, menuInfo -> {
            String menuName = menuInfo.split("-")[0].trim();
            if (!uniqueMenus.add(menuName)) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());
            }
            return true;
        });

        return uniqueMenus;
    }

    private static void validateTotalMenuCount(String order, int uniqueMenuCount) {
        int totalMenuCount = Arrays.stream(order.split(","))
                .mapToInt(OrderValidator::validateAndGetQuantity)
                .sum();

        if (totalMenuCount > MAX_MENU_COUNT || uniqueMenuCount > MAX_MENU_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.MAX_MENU_EXCEEDED.getMessage());
        }
    }

    private static int validateAndGetQuantity(String menuInfo) {
        String[] menuDetails = menuInfo.split("-");
        validateMenu(menuDetails);
        return Integer.parseInt(menuDetails[1].trim());
    }

    private static void validateMenu(String[] menuDetails) {
        String menuName = menuDetails[0].trim();
        if (!isValidMenu(menuName)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());
        }
        validateQuantity(menuDetails[1].trim());
    }

    private static boolean isValidMenu(String menuName) {
        return Arrays.stream(Menu.values()).anyMatch(menu -> menu.name().equals(menuName));
    }

    private static void validateQuantity(String quantityStr) {
        int quantity = Integer.parseInt(quantityStr);
        if (quantity < 1) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());
        }
    }
}
