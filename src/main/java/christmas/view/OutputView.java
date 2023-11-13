package christmas.view;

import christmas.model.Menu;
import java.util.List;

public class OutputView {


    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printEmptyLine() {
        System.out.println();
    }

    public static void printMenu(List<String> menus) {
        printMessage("<주문 메뉴>");
        for (String menu : menus) {
            String[] menuInfo = menu.split("-");
            String menuName = menuInfo[0];
            Menu.valueOf(menuName);
            int quantity = Integer.parseInt(menuInfo[1]);
            printMessage(menuName + " " + quantity + "개");
        }
        printEmptyLine();
    }

    public static void printPreviewPhrase(int date) {
        System.out.printf("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!%n", date);
    }

    public static void printTotalOrderAmount(int totalOrderAmount) {
        printMessage(String.format("<할인 전 총주문 금액>%n%s원", formatAmount(totalOrderAmount)));
        printEmptyLine();
    }

    private static String formatAmount(int amount) {
        return String.format("%,d", amount);
    }
}
