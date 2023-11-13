package christmas.view;

import christmas.model.DateDiscount;
import christmas.model.Menu;
import christmas.model.TotalDiscountCalculator;
import java.util.List;

public class OutputView {

    private static final String GIFT_MENU = "샴페인 1개";

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

    public static void printDiscountAmount(int date, List<String> menus, int totalOrderAmount) {
        printMessage("<혜택 내역>");

        int christmasDiscount = DateDiscount.dayDiscount(date);
        int weekdayDiscount = DateDiscount.weekDayDiscount(date, menus);
        int weekendDiscount = DateDiscount.weekendDayDiscount(date, menus);
        int starDiscount = TotalDiscountCalculator.calculateStarDiscount(date);
        int giftMenuDiscount = TotalDiscountCalculator.printGiftMenu(totalOrderAmount);

        printIfNonZero("크리스마스 디데이 할인", christmasDiscount);
        printIfNonZero("평일 할인", weekdayDiscount);
        printIfNonZero("주말 할인", weekendDiscount);
        printIfNonZero("특별 할인", starDiscount);
        printIfNonZero("증정 이벤트", giftMenuDiscount);

        if (christmasDiscount == 0 && weekdayDiscount == 0 && weekendDiscount == 0 && starDiscount == 0
                && giftMenuDiscount == 0) {
            printMessage("없음");
        }

        printEmptyLine();
    }

    private static void printIfNonZero(String label, int amount) {
        if (amount != 0) {
            printMessage(String.format("%s: -%s원", label, formatAmount(amount)));
        }
    }


    private static String formatAmount(int amount) {
        return String.format("%,d", amount);
    }
}
