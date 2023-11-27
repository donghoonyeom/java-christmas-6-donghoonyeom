package christmas.model;

import christmas.view.OutputView;
import java.util.HashSet;
import java.util.Set;

public class Order {
    private static final int MENU_NAME_INDEX = 0;
    private static final int QUANTITY_INDEX = 1;

    private final Set<OrderItem> menus;


    private Order(Set<OrderItem> menus) {
        this.menus = menus;
    }

    public static Order createOrder(int date, String orderInput) {
        Set<OrderItem> menus = createOrderItems(orderInput);
        OutputView.printOrderPreview(date);
        return new Order(menus);
    }

    private static Set<OrderItem> createOrderItems(String orderInput) {
        Set<OrderItem> menus = new HashSet<>();
        String[] orderItems = orderInput.split(",");
        for (String orderItem : orderItems) {
            String[] menuInfo = getMenuInfo(orderItem.trim());
            String menuName = menuInfo[MENU_NAME_INDEX];
            int quantity = Integer.parseInt(menuInfo[QUANTITY_INDEX]);
            menus.add(new OrderItem(menuName, quantity));
        }
        return menus;
    }

    private static String[] getMenuInfo(String menu) {
        return menu.split("-");
    }

    public Set<OrderItem> getMenus() {
        return menus;
    }

    public int calculateTotalOrderAmount() {
        int totalOrderAmount = 0;
        for (OrderItem orderItem : menus) {
            totalOrderAmount += orderItem.calculateMenuAmount();
        }
        return totalOrderAmount;
    }

    public int calculateTotalDiscount(int date) {
        int dateDiscount = TotalDiscountCalculator.calculateDateDiscount(date, menus);
        int starDiscount = TotalDiscountCalculator.calculateStarDiscount(date);
        return dateDiscount + starDiscount;
    }
}
