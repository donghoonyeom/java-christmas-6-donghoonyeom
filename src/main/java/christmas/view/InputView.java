package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.model.Menu;
import java.util.Arrays;

public class InputView {

    private static String getCustomerInput(String message) {
        System.out.println(message);
        return Console.readLine();
    }

    public static int getDate() {
        while (true) {
            System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
            String customerInput = getCustomerInput("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
            try {
                int date = Integer.parseInt(customerInput);
                if (date >= 1 && date <= 31) {
                    return date;
                } else {
                    throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            }
        }
    }

    public static String getOrder() {
        while (true) {
            String order = getCustomerInput("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
            try {
                validateOrderInput(order);
                return order;
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
    }

    private static void validateOrderInput(String order) {
        if (!order.matches("^[가-힣a-zA-Z0-9\\-]*(,[가-힣a-zA-Z0-9\\-]+-[0-9]+)*$")) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }

        if (containsEnglish(order)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }

        String[] menuInfo = order.split("-");
        String menuName = menuInfo[0];

        if (Arrays.stream(Menu.values()).noneMatch(menu -> menu.name().equals(menuName))) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private static boolean containsEnglish(String order) {
        return order.matches(".*[a-zA-Z]+.*");
    }
}
