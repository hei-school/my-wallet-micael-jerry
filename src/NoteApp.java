import model.Note;
import service.NoteService;
import view.BarView;
import view.MenuView;
import view.NoteView;

import java.util.List;
import java.util.Scanner;

public class NoteApp {
    public static void run (List<Note> noteList, Scanner sc) {
        boolean conditionRunning = true;
        while (conditionRunning) {
            BarView.bar("Note");
            MenuView.printMenu("Show", "Add", "Delete", "Exit");
            while (!sc.hasNextInt()) {
                System.out.println("Please enter a valid number");
                sc.next();
            }
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    NoteView.printNote(noteList);
                    break;
                case 2:
                    NoteService.add(noteList, sc);
                    break;
                case 3:
                    NoteService.delete(noteList, sc);
                    break;
                case 4:
                    conditionRunning = false;
                    break;
                default:
                    System.out.println("RETRY");
            }
        }
    }
}
