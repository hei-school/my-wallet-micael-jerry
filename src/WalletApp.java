import model.Wallet;
import service.WalletService;
import view.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WalletApp {
    public static void run () {
        Scanner sc = new Scanner(System.in);
        Wallet wallet = new Wallet();
        List<String> transaction = new ArrayList<>(); // TODO: transaction history

        System.out.println("Welcome");

        boolean conditionRunning = true;
        while (conditionRunning) {
            Menu.printMenu("Status", "Deposit", "Withdraw", "History", "Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    WalletService.printWallet(wallet);
                    break;
                case 2:
                    WalletService.deposit(wallet, sc);
                    break;
                case 3:
                    WalletService.withdrawal(wallet, sc);
                    break;
                case 4:
                    System.out.println("Not implemented");
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
