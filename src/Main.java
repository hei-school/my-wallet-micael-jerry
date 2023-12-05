import model.Wallet;
import service.WalletService;
import view.Menu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Wallet wallet = new Wallet();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome");

        boolean conditionRunning = true;
        while (conditionRunning) {
            Menu.printMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    WalletService.printWallet(wallet);
                    break;
                case 2:
                    conditionRunning = false;
                    System.out.println("Bye");
                    break;
                case 3:
                    WalletService.updateWallet(wallet, scanner);
                    break;
                case 4:
                    WalletService.withdrawal(wallet, scanner);
                default:
                    System.out.println("RETRY");
            }
        }
    }
}