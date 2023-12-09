package app;

import model.History;
import model.Note;
import model.Wallet;
import view.BarView;
import view.MenuView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WalletApp {
    public static void run () {
        Scanner sc = new Scanner(System.in);
        Wallet wallet = new Wallet();
        List<History> historyList = new ArrayList<>();
        List<Note> noteList = new ArrayList<>();

        System.out.println("Welcome");

        boolean conditionRunning = true;
        while (conditionRunning) {
            BarView.bar("Menu");
            MenuView.printMenu("Money", "Note", "Exit");
            while (!sc.hasNextInt()) {
                System.out.println("Please enter a valid number");
                sc.next();
            }
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    MoneyApp.run(wallet, historyList, sc);
                    break;
                case 2:
                    NoteApp.run(noteList, sc);
                    break;
                case 3:
                    conditionRunning = false;
                    System.out.println("Bye");
                    break;
                default:
                    System.out.println("RETRY");
            }
        }
    }
}
