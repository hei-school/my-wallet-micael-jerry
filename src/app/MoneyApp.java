package app;

import model.Money;
import service.MoneyService;
import view.BarView;
import view.MenuView;

import java.util.Scanner;

public class MoneyApp {
    public static void run (Money money, Scanner sc) {
        boolean conditionRunning = true;
        while (conditionRunning) {
            BarView.bar("Money");
            MenuView.printMenu("Status", "Deposit", "Withdraw", "Exit");
            while (!sc.hasNextInt()) {
                System.out.println("Please enter a valid number");
                sc.next();
            }
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    BarView.bar("Status");
                    MoneyService.printMoney(money);
                    break;
                case 2:
                    BarView.bar("Deposit");
                    MoneyService.deposit(money, sc);
                    break;
                case 3:
                    BarView.bar("Withdrawal");
                    MoneyService.withdrawal(money, sc);
                    break;
                case 4:
                    conditionRunning = false;
                    System.out.println("Bye");
                    break;
                default:
                    System.out.println("RETRY");
            }
        }
    }
}
