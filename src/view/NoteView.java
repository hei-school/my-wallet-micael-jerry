package view;

import model.History;
import model.Note;

import java.util.List;

public class NoteView {
    public static void printNote(List<Note> noteList) {
        BarView.bar("Note");
        if (noteList.isEmpty()) {
            System.out.println("Empty note");
            return;
        }
        for (int i = 0; i < noteList.size(); i++) {
            BarView.bar("NOTE " + (i + 1));
            Note note = noteList.get(i);
            System.out.println("id: " + (i + 1) + "     value: " + note.getValue()  + " date: " + note.getTimestamp().toString());
        }
    }
}
