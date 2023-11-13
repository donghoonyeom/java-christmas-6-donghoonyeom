package christmas;

import christmas.controller.EventPlanner;
import christmas.model.Order;
import christmas.view.InputView;

public class Application {
    public static void main(String[] args) {
        int date = InputView.getDate();
        Order order = Order.createOrder(date);
        EventPlanner.planEvent(order, date);
    }
}
