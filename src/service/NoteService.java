package service;

import model.Note;

import java.util.List;
import java.util.Scanner;

public class NoteService {

    public static void add (List<Note> noteList, Scanner sc) {
        Note note = new Note();
        System.out.println("Note title");
        note.setKey(sc.next());
        System.out.println("Note content");
        note.setValue(sc.next());
        noteList.add(note);
        System.out.println("Note added");
    }

    public static void delete (List<Note> noteList, Scanner sc) {
        System.out.println("Enter id");
        if (sc.hasNextInt() && sc.nextInt() >= 1 && sc.nextInt() <= noteList.size()) {
            int id = sc.nextInt();
            noteList.remove(id - 1);
            System.out.println("Deleted");
        } else {
            sc.next();
            System.out.println("Invalid Input - retry");
        }
    }
}
