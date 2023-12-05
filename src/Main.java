import model.Wallet;
import service.WalletService;
import view.Menu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Wallet wallet = new Wallet();

        System.out.println("Welcome");

        boolean conditionRunning = true;
        while (conditionRunning) {
            Menu.printMenu();
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    WalletService.printWallet(wallet);
                    break;
                case 2:
                    conditionRunning = false;
                    System.out.println("Bye");
                    break;
                default:
                    System.out.println("RETRY");
            }
        }
    }
}