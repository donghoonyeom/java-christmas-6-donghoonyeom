import christmas.model.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Menu 테스트")
class MenuTest {

    @Test
    @DisplayName("샴페인 가격을 올바르게 가져오는지 확인")
    void getChampagnePrice() {
        int expectedPrice = 25_000;

        int actualPrice = Menu.getChampagnePrice();

        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    @DisplayName("메뉴 이름에 해당하는 가격을 올바르게 가져오는지 확인")
    void getPriceByMenuName() {
        String menuName = "크리스마스파스타";
        int expectedPrice = 25_000;

        int actualPrice = Menu.getPriceByMenuName(menuName);

        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    @DisplayName("메뉴의 가격을 올바르게 가져오는지 확인")
    void getPrice() {
        Menu menu = Menu.초코케이크;
        int expectedPrice = 15_000;

        int actualPrice = menu.getPrice();

        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    @DisplayName("음료 메뉴를 정확히 판별하는지 확인")
    void containsBeverageMenu() {
        assertTrue(Menu.레드와인.containsBeverageMenu("레드와인"));
        assertFalse(Menu.레드와인.containsBeverageMenu("크리스마스파스타"));
    }

    @Test
    @DisplayName("메인 메뉴를 정확히 판별하는지 확인")
    void containsMainMenu() {
        assertTrue(Menu.바비큐립.containsMainMenu("바비큐립"));
        assertFalse(Menu.바비큐립.containsMainMenu("샴페인"));
    }

    @Test
    @DisplayName("디저트 메뉴를 정확히 판별하는지 확인")
    void containsDessertMenu() {
        assertTrue(Menu.아이스크림.containsDessertMenu("아이스크림"));
        assertFalse(Menu.아이스크림.containsDessertMenu("시저샐러드"));
    }
}
