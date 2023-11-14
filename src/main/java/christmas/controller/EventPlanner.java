package christmas.controller;

import christmas.model.Order;
import christmas.view.OrderOutputPrinter;
import christmas.view.OutputView;

public class EventPlanner {
    private static final int MIN_TOTAL_ORDER_AMOUNT_FOR_EVENTS = 10000;

    public static void planEvent(Order order, int date) {
        int totalOrderAmount = order.calculateTotalOrderAmount();

        printOrderDetails(order, totalOrderAmount);

        processEventBasedOnTotalAmount(order, date, totalOrderAmount);
    }

    private static void printOrderDetails(Order order, int totalOrderAmount) {
        OrderOutputPrinter.printMenu(order.getMenus());
        OutputView.printTotalOrderAmount(totalOrderAmount);
    }

    private static void processEventBasedOnTotalAmount(Order order, int date, int totalOrderAmount) {
        if (totalOrderAmount >= MIN_TOTAL_ORDER_AMOUNT_FOR_EVENTS) {
            EventProcessor.processEvent(order, date, totalOrderAmount);
        }

        if (totalOrderAmount < MIN_TOTAL_ORDER_AMOUNT_FOR_EVENTS) {
            NoEventProcessor.processNoEvent(order, date, totalOrderAmount);
        }
    }
}
