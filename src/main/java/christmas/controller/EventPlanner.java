package christmas.controller;

import christmas.model.Order;
import christmas.model.TotalDiscountCalculator;
import christmas.view.OutputView;

public class EventPlanner {
    public static void planEvent(Order order, int date) {
        int totalOrderAmount = order.calculateTotalOrderAmount();
        int totalDiscount = order.calculateTotalDiscount(date);
        int totalBenefits = TotalDiscountCalculator.calculateGiftMenu(totalOrderAmount, totalDiscount);
        int totalPayment = totalOrderAmount - totalDiscount;
        String giftMenu = OutputView.calculateGiftMenu(totalOrderAmount);

        OutputView.printMenu(order.getMenus());
        OutputView.printTotalOrderAmount(totalOrderAmount);
        OutputView.printGiftMenu(giftMenu);
        OutputView.printDiscountAmount(date, order.getMenus(), totalOrderAmount);
        OutputView.printBenefits(totalBenefits);
        OutputView.printPayment(totalPayment);

        String badge = order.calculateBadge(date);
        OutputView.printBadge(badge);
    }
}
