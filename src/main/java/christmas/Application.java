package christmas;

import christmas.controller.EventPlanner;
import christmas.model.Order;
import christmas.view.InputView;

public class Application {
    public static void main(String[] args) {
        int date = InputView.getDate();
        String orderInput = InputView.getOrder();
        Order order = Order.createOrder(date, orderInput);
        EventPlanner.planEvent(order, date);
    }
}
