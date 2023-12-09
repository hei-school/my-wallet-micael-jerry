package app;

import model.Wallet;
import view.BarView;
import view.MenuView;

import java.util.Scanner;

public class WalletApp {
    public static void run () {
        Scanner sc = new Scanner(System.in);
        Wallet wallet = new Wallet();

        System.out.println("Welcome");

        boolean conditionRunning = true;
        while (conditionRunning) {
            BarView.bar("Menu");
            MenuView.printMenu("Money", "Exit");
            while (!sc.hasNextInt()) {
                System.out.println("Please enter a valid number");
                sc.next();
            }
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    MoneyApp.run(wallet.getMoney(), sc);
                    break;
                case 2:
                    conditionRunning = false;
                    System.out.println("Bye");
                    sc.close();
                    break;
                default:
                    System.out.println("RETRY");
            }
        }
    }
}
