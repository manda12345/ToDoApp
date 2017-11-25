package com.bridgelabz.User.Service;

import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.User.DAO.NoteDAO;
import com.bridgelabz.User.model.Note;

@Service
public class NoteServiceImplemention implements NoteServices {

	@Autowired
	private NoteDAO noteDao;

	@Transactional
	public void addNote(Note note) {
		noteDao.addNote(note);
	}

	@Transactional
	public void deleteNote(int noteId) {
		noteDao.deleteNote(noteId);
	}

	@Transactional
	public void updateNote(Note updatedNote) {

		Note persistedNote = noteDao.getNoteById(updatedNote.getNoteId());
		Date toDay = new Date();
		updatedNote.setModifiedDate(toDay);
		updatedNote.setCreatedDate(persistedNote.getCreatedDate());
		noteDao.updateNote(updatedNote);
	}

	@Transactional
	public List<Note> getallNotes() {

		return noteDao.getallNotes();
	} 

	@Transactional
	public Note getNoteById(int noteId) {
		return noteDao.getNoteById(noteId);
	}
}