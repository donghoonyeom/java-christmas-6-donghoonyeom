package christmas.validator;

public enum ErrorMessage {
    INVALID_DATE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INVALID_ORDER("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    MAX_MENU_EXCEEDED("[ERROR] 한 번에 최대 20개의 메뉴만 주문 가능합니다. 다시 입력해 주세요."),
    BEVERAGE_ONLY_ORDER("[ERROR] 음료만 주문 할 수는 없습니다. 다시 입력해 주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
