package christmas.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Menu 테스트")
class MenuTest {

    @Test
    @DisplayName("샴페인 가격을 올바르게 가져오는지 확인")
    void getChampagnePrice() {
        verifyMenuPrice(Menu.샴페인, 25_000);
    }

    @Test
    @DisplayName("메뉴 이름에 해당하는 가격을 올바르게 가져오는지 확인")
    void getPriceByMenuName() {
        verifyMenuPriceByName("크리스마스파스타", 25_000);
    }

    @Test
    @DisplayName("메뉴의 가격을 올바르게 가져오는지 확인")
    void getPrice() {
        verifyMenuPrice(Menu.초코케이크, 15_000);
    }

    @Test
    @DisplayName("음료 메뉴를 정확히 판별하는지 확인")
    void containsBeverageMenu() {
        verifyBeverageMenuType(Menu.레드와인, "레드와인", true);
        verifyBeverageMenuType(Menu.레드와인, "크리스마스파스타", false);
    }

    @Test
    @DisplayName("메인 메뉴를 정확히 판별하는지 확인")
    void containsMainMenu() {
        verifyMainMenuType(Menu.바비큐립, "바비큐립", true);
        verifyMainMenuType(Menu.바비큐립, "샴페인", false);
    }

    @Test
    @DisplayName("디저트 메뉴를 정확히 판별하는지 확인")
    void containsDessertMenu() {
        verifyDessertMenuType(Menu.아이스크림, "아이스크림", true);
        verifyDessertMenuType(Menu.아이스크림, "시저샐러드", false);
    }

    private void verifyMenuPrice(Menu menu, int expectedPrice) {
        int actualPrice = menu.getPrice();
        assertEquals(expectedPrice, actualPrice);
    }

    private void verifyMenuPriceByName(String menuName, int expectedPrice) {
        int actualPrice = Menu.getPriceByMenuName(menuName);
        assertEquals(expectedPrice, actualPrice);
    }

    private void verifyBeverageMenuType(Menu menu, String menuItem, boolean expectedResult) {
        boolean actualResult = menu.containsBeverageMenu(menuItem);
        assertEquals(expectedResult, actualResult);
    }

    private void verifyDessertMenuType(Menu menu, String menuItem, boolean expectedResult) {
        boolean actualResult = menu.containsDessertMenu(menuItem);
        assertEquals(expectedResult, actualResult);
    }

    private void verifyMainMenuType(Menu menu, String menuItem, boolean expectedResult) {
        boolean actualResult = menu.containsMainMenu(menuItem);
        assertEquals(expectedResult, actualResult);
    }
}
