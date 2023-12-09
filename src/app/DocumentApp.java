package app;

import model.Document;
import service.DocumentService;
import view.BarView;
import view.MenuView;

import java.util.List;
import java.util.Scanner;

public class DocumentApp {
    public static void run(List<Document> documentList, Scanner sc) {
        boolean conditionRunning = true;
        while (conditionRunning) {
            BarView.bar("Document");
            MenuView.printMenu("Status", "Add", "Remove", "Exit");
            while (!sc.hasNextInt()) {
                System.out.println("Please enter a valid number");
                sc.next();
            }
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    BarView.bar("Status");
                    DocumentService.printDocumentGroupByType(documentList);
                    break;
                case 2:
                    BarView.bar("Add");
                    DocumentService.addDocument(documentList, sc);
                    break;
                case 3:
                    BarView.bar("Remove");
                    DocumentService.removeDocument(documentList, sc);
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
