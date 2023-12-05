package service;

import model.Wallet;

import java.util.Scanner;

public class WalletService {
    public static void printWallet (Wallet wallet) {
        System.out.println("Wallet: " + "\n  owner: " + wallet.getOwner() + "\n  sold: " + wallet.getSold());
    }

    public static void updateOwner (Wallet wallet, Scanner sc) {
        System.out.println("Your name: ");
        wallet.setOwner(sc.next());
        System.out.println("Name changed");
    }

    public static void updateSold (Wallet wallet, Scanner sc) {
        System.out.println("Sold: ");
        if (sc.hasNextDouble()) {
            wallet.setSold(sc.nextDouble());
            System.out.println("Sold updated");
        } else {
            sc.next();
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
