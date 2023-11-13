package christmas.model;

import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.Arrays;
import java.util.List;

public class Order {
    private final List<String> menus;

    public Order(List<String> menus) {
        this.menus = menus;
    }

    public static Order createOrder(int date) {
        String orderInput = InputView.getOrder();
        List<String> menus = Arrays.asList(orderInput.split(","));
        OutputView.printPreviewPhrase(date);
        OutputView.printEmptyLine();
        return new Order(menus);
    }

    public List<String> getMenus() {
        return menus;
    }

    public int calculateTotalOrderAmount() {
        int totalOrderAmount = 0;
        for (String menu : menus) {
            totalOrderAmount += calculateMenuAmount(menu.trim());
        }
        return totalOrderAmount;
    }

    private int calculateMenuAmount(String menu) {
        String[] menuInfo = menu.split("-");

        String menuName = menuInfo[0];
        int quantity = Integer.parseInt(menuInfo[1]);

        return quantity * Menu.valueOf(menuName).getPrice();
    }

    public int calculateTotalDiscount(int date) {
        int dateDiscount = TotalDiscountCalculator.calculateDateDiscount(date, menus);
        int starDiscount = TotalDiscountCalculator.calculateStarDiscount(date);
        return dateDiscount + starDiscount;
    }

    public String calculateBadge(int date) {
        int totalBenefits = calculateTotalOrderAmount() - calculateTotalDiscount(date);
        return BadgeCalculator.calculateBadge(totalBenefits);
    }
}
