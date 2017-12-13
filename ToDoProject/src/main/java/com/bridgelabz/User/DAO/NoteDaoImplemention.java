package com.bridgelabz.User.DAO;
import java.util.List;
import java.util.logging.LogManager;

import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bridgelabz.User.model.Note;

@Repository
public class NoteDaoImplemention implements NoteDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	NoteDAO noteDAO;
	

	public int saveNotes(Note note) {

		Session session = sessionFactory.getCurrentSession();
		int id=	(int) session.save(note);
		return id;
	}

	@Override
	public void deleteNote(int noteId) {

		Session session = sessionFactory.getCurrentSession();
		Note persistedNote = session.load(Note.class, noteId);
		if (persistedNote != null) {
			session.delete(persistedNote);
		}
	}

	@Override
	public void updateNote(Note note) {
		System.out.println("noteId=" + note.getNoteId() + ", title=" + note.getTitle() + ", description=" + note.getDescription() + ", createdDate="+ note.getCreatedDate() + ", modifiedDate=" + note.getModifiedDate());
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(note);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Note> getallNotes() {

		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Note ");
		List<Note> ls = query.getResultList();
		return ls;
	}
	@Override
	public Note getNoteById(int noteId) {
		Session session = sessionFactory.getCurrentSession();
		return session.load(Note.class, noteId);
	}

	@Override
	public boolean updateArchive(int noteId)
	{
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery( "UPDATE com.bridgelabz.User.model.Note set isArchive=:isArchive WHERE noteId = :noteId");
		query.setParameter("noteId", noteId);
		query.setParameter("isArchive", true);
		query.executeUpdate();
		System.out.println("query executed successfully...");
		return true;
	}

	@Override
	public boolean updateTrash(int noteId)
	{
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery( "UPDATE com.bridgelabz.User.model.Note set emptyTrash=:emptyTrash WHERE noteId = :noteId");
		query.setParameter("noteId", noteId);
		query.setParameter("emptyTrash", true);
		query.executeUpdate();
		System.out.println("query executed successfully...");
		return true;
	}

}
