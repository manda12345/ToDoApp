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
	public int saveNotes(Note note) {
		int id=noteDao.saveNotes(note);
		return id;
	}
	
	@Transactional
	public void deleteNote(int noteId) {
		noteDao.deleteNote(noteId);
	}

	@Transactional
	public void updateNote(Note updatedNote) {
		  System.out.println("it was updating");
        Note persistedNote = noteDao.getNoteById(updatedNote.getNoteId());
		Date toDay= new Date();
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

	@Transactional
	public boolean updateArchive(int NoteId)
	{
		noteDao.updateArchive(NoteId);
		return true;
	}

	@Transactional
	public void emptyTrash(int userId) {
		
		noteDao.emptyTrash(userId);
	}
	@Transactional
	public boolean UpdateNoteToTrash(int noteId)
	{
		noteDao.UpdateNoteToTrash(noteId);
		return true;
	}

	@Transactional
	public boolean updatePin(int noteId)
	{
		noteDao.updatePin(noteId);
		return true;
	}
}
