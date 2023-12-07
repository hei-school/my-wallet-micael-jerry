package view;

public class MenuView {
    public static void printMenu(String ...menu) {
        BarView.bar("Menu");
        for (int i = 0; i < menu.length; i++) {
            System.out.println((i + 1) + ". " + menu[i]);
        }
    }
}
