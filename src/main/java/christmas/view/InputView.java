package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.validator.DateValidator;
import christmas.validator.OrderValidator;

public class InputView {

    private static final String GREETING_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";

    public static int getDate() {
        OutputView.printMessage(GREETING_MESSAGE);
        return getValidatedDate();
    }

    public static String getOrder() {
        return getValidatedOrder();
    }

    private static String getValidatedOrder() {
        while (true) {
            try {
                return validateAndRetrieveOrder();
            } catch (IllegalArgumentException e) {
                handleValidationError(e);
            }
        }
    }

    private static int getValidatedDate() {
        while (true) {
            try {
                return validateAndRetrieveDate();
            } catch (IllegalArgumentException e) {
                handleValidationError(e);
            }
        }
    }

    private static String validateAndRetrieveOrder() {
        String order = getCustomerInput("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        return OrderValidator.validateAndGetOrder(order);
    }

    private static int validateAndRetrieveDate() {
        String customerInput = getCustomerInput("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        return DateValidator.validateAndGetDate(customerInput);
    }

    private static String getCustomerInput(String message) {
        OutputView.printMessage(message);
        return Console.readLine();
    }

    private static void handleValidationError(IllegalArgumentException e) {
        OutputView.printMessage(e.getMessage());
    }
}
