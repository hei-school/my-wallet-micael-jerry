package service;

import model.Wallet;

import java.util.Scanner;

public class WalletService {
    public static void printWallet (Wallet wallet) {
        System.out.println("Wallet: " + "\n  owner: " + wallet.getOwner() + "\n  sold: " + wallet.getSold());
    }

    public static void deposit(Wallet wallet, Scanner sc) {
        System.out.println("Money to deposit: ");
        if (sc.hasNextDouble()) {
            wallet.setSold(wallet.getSold() + sc.nextDouble());
            System.out.println("Deposit successfully");
        } else {
            sc.next();
            System.out.println("Invalid Input - retry");
        }
    }

    public static void withdrawal (Wallet wallet, Scanner sc) {
        System.out.println("Amount to withdraw: ");
        while (!sc.hasNextInt()) {
            System.out.println("Invalid Input");
            sc.next();
        }
        double amount = sc.nextInt();
        if (amount > wallet.getSold()) {
            System.out.println("Insufficient balance");
        }
        else {
            wallet.setSold(wallet.getSold() - amount);
            System.out.println("withdrawal successfully");
        }
    }
}
