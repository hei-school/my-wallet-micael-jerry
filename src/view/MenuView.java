package view;

public class MenuView {
    public static void printMenu(String ...menu) {
        for (int i = 0; i < menu.length; i++) {
            System.out.println((i + 1) + ". " + menu[i]);
        }
    }
}
