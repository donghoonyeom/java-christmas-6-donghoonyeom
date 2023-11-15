package christmas.model;

import java.util.Arrays;

public enum Menu {
    양송이수프(6_000),
    타파스(5_500),
    시저샐러드(8_000),
    티본스테이크(55_000),
    바비큐립(54_000),
    해산물파스타(35_000),
    크리스마스파스타(25_000),
    초코케이크(15_000),
    아이스크림(5_000),
    제로콜라(3_000),
    레드와인(60_000),
    샴페인(25_000);

    private final int price;

    Menu(int price) {
        this.price = price;
    }

    public static int getChampagnePrice() {
        return 샴페인.getPrice();
    }

    public static int getPriceByMenuName(String menuName) {
        return Menu.valueOf(menuName).getPrice();
    }

    public static boolean containsMenu(String menuName) {
        return Arrays.stream(values()).anyMatch(menu -> menu.name().equals(menuName));
    }

    public int getPrice() {
        return price;
    }

    public boolean containsBeverageMenu(String menuName) {
        return Arrays.asList(제로콜라.name(), 레드와인.name(), 샴페인.name()).contains(menuName);
    }

    public boolean containsMainMenu(String menuName) {
        return Arrays.asList(티본스테이크.name(), 바비큐립.name(), 해산물파스타.name(), 크리스마스파스타.name()).contains(menuName);
    }

    public boolean containsDessertMenu(String menuName) {
        return Arrays.asList(초코케이크.name(), 아이스크림.name()).contains(menuName);
    }

}
