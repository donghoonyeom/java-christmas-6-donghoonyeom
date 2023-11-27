package christmas.model;

public class OrderItem {
    private final String menuName;
    private final int quantity;

    public OrderItem(String menuName, int quantity) {
        this.menuName = menuName;
        this.quantity = quantity;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getQuantity() {
        return quantity;
    }

    public int calculateMenuAmount() {
        return quantity * Menu.getPriceByMenuName(menuName);
    }
}
