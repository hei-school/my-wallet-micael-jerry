package app;

import model.History;
import model.OperationType;
import model.Wallet;
import service.WalletService;
import view.BarView;
import view.HistoryView;
import view.MenuView;

import java.util.List;
import java.util.Scanner;

public class MoneyApp {
    public static void run (Wallet wallet, List<History> historyList, Scanner sc) {
        boolean conditionRunning = true;
        while (conditionRunning) {
            BarView.bar("Money");
            MenuView.printMenu("Status", "Deposit", "Withdraw", "History", "Exit");
            while (!sc.hasNextInt()) {
                System.out.println("Please enter a valid number");
                sc.next();
            }
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    BarView.bar("Status");
                    WalletService.printWallet(wallet);
                    historyList.add(new History(OperationType.STATUS, new Wallet(wallet.getSold())));
                    break;
                case 2:
                    BarView.bar("Deposit");
                    WalletService.deposit(wallet, sc);
                    historyList.add(new History(OperationType.DEPOSIT, new Wallet(wallet.getSold())));
                    break;
                case 3:
                    BarView.bar("Withdrawal");
                    WalletService.withdrawal(wallet, sc);
                    historyList.add(new History(OperationType.WITHDRAW, new Wallet(wallet.getSold())));
                    break;
                case 4:
                    BarView.bar("History");
                    HistoryView.printHistory(historyList);
                    break;
                case 5:
                    conditionRunning = false;
                    System.out.println("Bye");
                    break;
                default:
                    System.out.println("RETRY");
            }
        }
    }
}
