package christmas.controller;

import christmas.model.Badge;
import christmas.model.Order;
import christmas.view.OutputView;

public class NoEventProcessor {
    public static void processNoEvent(Order order, int date, int totalOrderAmount) {
        int totalDiscount = 0;
        int totalBenefits = 0;
        int totalPayment = totalOrderAmount - totalDiscount;

        EventProcessor.printDiscountAmount(date, order.getMenus(), totalDiscount);
        EventProcessor.printBenefits(totalBenefits);
        EventProcessor.printPayment(totalPayment);

        OutputView.printBadge(Badge.NONE.getName());
    }
}
