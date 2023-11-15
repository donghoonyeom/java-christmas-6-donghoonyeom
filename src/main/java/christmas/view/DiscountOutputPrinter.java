package christmas.view;

import christmas.model.DateDiscount;
import christmas.model.OrderItem;
import christmas.model.TotalDiscountCalculator;
import christmas.model.WeekendWeekdayDiscount;
import java.util.Set;

public class DiscountOutputPrinter {
    private static final String NONE_BENEFIT_MESSAGE = "없음";

    public static void printDiscountAmount(int date, Set<OrderItem> menus, int totalOrderAmount) {
        OutputView.printMessage("<혜택 내역>");

        printDiscount("크리스마스 디데이 할인", DateDiscount.ddayDiscount(date));
        printDiscount("평일 할인", WeekendWeekdayDiscount.weekDayDiscount(date, menus));
        printDiscount("주말 할인", WeekendWeekdayDiscount.weekendDayDiscount(date, menus));
        printDiscount("특별 할인", TotalDiscountCalculator.calculateStarDiscount(date));
        printDiscount("증정 이벤트", TotalDiscountCalculator.printGiftMenuPrice(totalOrderAmount));

        if (allDiscountsZero(date, menus, totalOrderAmount)) {
            OutputView.printMessage(NONE_BENEFIT_MESSAGE);
        }
        OutputView.printEmptyLine();
    }

    private static void printDiscount(String label, int discount) {
        printIfNonZero(label, discount);
    }

    private static boolean allDiscountsZero(int date, Set<OrderItem> menus, int totalOrderAmount) {
        return DateDiscount.ddayDiscount(date) == 0 && WeekendWeekdayDiscount.weekDayDiscount(date, menus) == 0
                && WeekendWeekdayDiscount.weekendDayDiscount(date, menus) == 0
                && TotalDiscountCalculator.calculateStarDiscount(date) == 0
                && TotalDiscountCalculator.printGiftMenuPrice(totalOrderAmount) == 0;
    }

    private static void printIfNonZero(String label, int amount) {
        if (amount != 0) {
            OutputView.printMessage(String.format("%s: -%s원", label, OutputView.formatAmount(amount)));
        }
    }

    public static void printBenefits(int totalBenefits) {
        if (totalBenefits != 0) {
            OutputView.printMessage(String.format("<총혜택 금액>%n-%s원", OutputView.formatAmount(totalBenefits)));
            OutputView.printEmptyLine();
        }

        if (totalBenefits == 0) {
            OutputView.printMessage(String.format("<총혜택 금액>%n%s원", OutputView.formatAmount(totalBenefits)));
            OutputView.printEmptyLine();
        }
    }
}
