package christmas.view;


public class OutputView {

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printEmptyLine() {
        System.out.println();
    }


    public static void printPreviewPhrase(int date) {
        System.out.printf("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!%n", date);
    }

    public static void printTotalOrderAmount(int totalOrderAmount) {
        printMessage(String.format("<할인 전 총주문 금액>%n%s원", formatAmount(totalOrderAmount)));
        printEmptyLine();
    }

    public static void printGiftMenuPhrase(String giftMenu) {
        printMessage(String.format("<증정 메뉴>%n%s", giftMenu));
        printEmptyLine();
    }

    public static void printPayment(int totalPayment) {
        printMessage(String.format("<할인 후 예상 결제 금액>%n%s원", formatAmount(totalPayment)));
        printEmptyLine();
    }

    public static void printBadge(String badge) {
        printMessage(String.format("<12월 이벤트 배지>%n%s", badge));
    }

    public static String formatAmount(int amount) {
        return String.format("%,d", amount);
    }
}
