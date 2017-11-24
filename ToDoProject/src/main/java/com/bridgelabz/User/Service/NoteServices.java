package com.bridgelabz.User.Service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.bridgelabz.User.model.Note;

@Service
public interface NoteServices {
	
	public void addNote(Note note);
	public void deleteNote(int noteId);
	public void updateNote(Note updatedNote);
	public List<Note> getallNotes();
}
