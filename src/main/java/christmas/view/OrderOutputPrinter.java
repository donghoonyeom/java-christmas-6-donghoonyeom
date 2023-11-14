package christmas.view;

import christmas.model.OrderItem;
import java.util.Set;

public class OrderOutputPrinter {
    private static final String GIFT_MENU_MESSAGE = "샴페인 1개";
    private static final String NONE_BENEFIT_MESSAGE = "없음";

    public static void printMenu(Set<OrderItem> menus) {
        OutputView.printMessage("<주문 메뉴>");
        menus.forEach(OrderOutputPrinter::printMenuItem);
        OutputView.printEmptyLine();
    }

    private static void printMenuItem(OrderItem orderItem) {
        String menuName = orderItem.getMenuName();
        int quantity = orderItem.getQuantity();
        OutputView.printMessage(menuName + " " + quantity + "개");
    }

    public static String printGiftMenuMessage(int totalOrderAmount) {
        if (totalOrderAmount >= 120000) {
            return GIFT_MENU_MESSAGE;
        }
        return NONE_BENEFIT_MESSAGE;
    }
}
