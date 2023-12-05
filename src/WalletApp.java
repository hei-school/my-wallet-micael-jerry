import model.History;
import model.OperationType;
import model.Wallet;
import service.WalletService;
import view.HistoryView;
import view.MenuView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WalletApp {
    public static void run () {
        Scanner sc = new Scanner(System.in);
        Wallet wallet = new Wallet();
        List<History> historyList = new ArrayList<>();

        System.out.println("Welcome");

        boolean conditionRunning = true;
        while (conditionRunning) {
            MenuView.printMenu("Status", "Deposit", "Withdraw", "History", "Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    WalletService.printWallet(wallet);
                    historyList.add(new History(OperationType.STATUS, new Wallet(wallet.getOwner(), wallet.getSold())));
                    break;
                case 2:
                    WalletService.deposit(wallet, sc);
                    historyList.add(new History(OperationType.DEPOSIT, new Wallet(wallet.getOwner(), wallet.getSold())));
                    break;
                case 3:
                    WalletService.withdrawal(wallet, sc);
                    historyList.add(new History(OperationType.WITHDRAW, new Wallet(wallet.getOwner(), wallet.getSold())));
                    break;
                case 4:
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
