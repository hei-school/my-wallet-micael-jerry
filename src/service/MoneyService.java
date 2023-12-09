package service;

import model.Money;

import java.util.Scanner;

public class MoneyService {
    public static void printMoney(Money money) {
        System.out.println("Money: " + "\n  sold: " + money.getSold());
    }

    public static void deposit(Money money, Scanner sc) {
        System.out.println("Money to deposit: ");
        if (sc.hasNextDouble()) {
            money.setSold(money.getSold() + sc.nextDouble());
            System.out.println("Deposit successfully");
        } else {
            sc.next();
            System.out.println("Invalid Input - retry");
        }
    }

    public static void withdrawal (Money money, Scanner sc) {
        System.out.println("Amount to withdraw: ");
        while (!sc.hasNextInt()) {
            System.out.println("Invalid Input");
            sc.next();
        }
        double amount = sc.nextInt();
        if (amount > money.getSold()) {
            System.out.println("Insufficient balance");
        }
        else {
            money.setSold(money.getSold() - amount);
            System.out.println("withdrawal successfully");
        }
    }
}
