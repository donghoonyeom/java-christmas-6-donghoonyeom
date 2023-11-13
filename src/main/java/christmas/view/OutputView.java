package christmas.view;

import christmas.model.Menu;
import java.util.List;

public class OutputView {


    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printEmptyLine() {
        System.out.println();
    }

    public static void printMenu(List<String> menus) {
        printMessage("<주문 메뉴>");
        for (String menu : menus) {
            String[] menuInfo = menu.split("-");
            String menuName = menuInfo[0];
            Menu.valueOf(menuName);
            int quantity = Integer.parseInt(menuInfo[1]);
            printMessage(menuName + " " + quantity + "개");
        }
        printEmptyLine();
    }

}
