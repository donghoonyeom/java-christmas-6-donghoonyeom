package christmas.controller;

import christmas.model.Order;
import christmas.model.OrderItem;
import christmas.model.TotalDiscountCalculator;
import christmas.view.DiscountOutputPrinter;
import christmas.view.OrderOutputPrinter;
import christmas.view.OutputView;
import java.util.Set;

public class EventProcessor {
    public static void processEvent(Order order, int date, int totalOrderAmount) {
        int totalDiscount = calculateTotalDiscount(order, date);
        int totalBenefits = TotalDiscountCalculator.calculateGiftMenu(totalOrderAmount, totalDiscount);
        int totalPayment = totalOrderAmount - totalDiscount;
        String giftMenu = OrderOutputPrinter.printGiftMenuMessage(totalOrderAmount);

        OutputView.printGiftMenuPhrase(giftMenu);
        printDiscountAmount(date, order.getMenus(), totalOrderAmount);
        printBenefits(totalBenefits);
        printPayment(totalPayment);

        String badge = order.calculateBadge(date);
        OutputView.printBadge(badge);
    }

    public static int calculateTotalDiscount(Order order, int date) {
        return order.calculateTotalDiscount(date);
    }

    public static void printDiscountAmount(int date, Set<OrderItem> menus, int totalOrderAmount) {
        DiscountOutputPrinter.printDiscountAmount(date, menus, totalOrderAmount);
    }

    public static void printBenefits(int totalBenefits) {
        DiscountOutputPrinter.printBenefits(totalBenefits);
    }

    public static void printPayment(int totalPayment) {
        OutputView.printPayment(totalPayment);
    }

}
