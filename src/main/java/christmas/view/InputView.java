package christmas.view;

import camp.nextstep.edu.missionutils.Console;

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
                System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
