package christmas.validator;

public class DateValidator {

    public static int validateAndGetDate(String input) {
        int date = parseDate(input);
        validateDateRange(date);
        return date;
    }

    private static int parseDate(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DATE.getMessage());
        }
    }

    private static void validateDateRange(int date) {
        if (date < 1 || date > 31) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DATE.getMessage());
        }
    }
}
