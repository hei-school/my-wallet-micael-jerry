package service;

import model.Wallet;

public class WalletService {
    public static void printWallet (Wallet wallet) {
        System.out.println("Wallet: " + "\n  owner: " + wallet.getOwner() + "\n  sold: " + wallet.getSold());
    }
}
