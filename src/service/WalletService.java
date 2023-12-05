package service;

import model.Wallet;

import java.util.Scanner;

public class WalletService {
    public static void printWallet (Wallet wallet) {
        System.out.println("Wallet: " + "\n  owner: " + wallet.getOwner() + "\n  sold: " + wallet.getSold());
    }

    public static void updateWallet (Wallet wallet, Scanner scanner) {
        System.out.println("Your name: ");
        wallet.setOwner(scanner.nextLine());
        System.out.println("Sold: ");
        wallet.setSold(scanner.nextDouble());
        System.out.println("Update successfully");
    }

    public static void withdrawal (Wallet wallet, Scanner scanner) {
        System.out.println("Amount to withdraw: ");
        double amount = scanner.nextInt();
        if (amount > wallet.getSold()) {
            System.out.println("Insufficient balance");
        }
        else {
            wallet.setSold(wallet.getSold() - amount);
            System.out.println("withdrawal successfully");
        }
    }
}
