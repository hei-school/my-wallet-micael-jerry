import model.Wallet;
import service.WalletService;
import view.Menu;

import java.util.Scanner;

public class WalletApp {
    public static void run () {
        Scanner sc = new Scanner(System.in);
        Wallet wallet = new Wallet();

        System.out.println("Welcome");

        boolean conditionRunning = true;
        while (conditionRunning) {
            Menu.printMenu("Status", "Update", "Withdraw", "Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    WalletService.printWallet(wallet);
                    break;
                case 2:
                    WalletService.updateOwner(wallet, sc);
                    WalletService.updateSold(wallet, sc);
                    break;
                case 3:
                    WalletService.withdrawal(wallet, sc);
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
