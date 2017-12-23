/*package com.bridgelabz.User.DAO;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.User.model.NoteLabel;
import com.bridgelabz.User.model.User;

@Service
public class LabelDaoImp implements LabelDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	User user;

	@Override
	public void addLabel(NoteLabel label) {

		Session session=sessionFactory.getCurrentSession();
		session.save(label);

	}

	@Override
	public 	NoteLabel getLabelByName(String labelName)
	{
		Session session = sessionFactory.getCurrentSession();
		NoteLabel objLabel = null;
		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(NoteLabel.class);
		criteria.add(Restrictions.eq("labelName", labelName));
		objLabel = (NoteLabel) criteria.uniqueResult();
		return objLabel;
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<NoteLabel> getLabels(User user) {
		Session session = sessionFactory.getCurrentSession();
		// transaction = (Transaction) session.beginTransaction();
		Criteria criteria = session.createCriteria(NoteLabel.class);
		criteria.add(Restrictions.eqOrIsNull("user", user));
		List<NoteLabel> labels = criteria.list();
		return labels;
}
	@SuppressWarnings("deprecation")
	@Override
	public boolean deletelabelById(int id)
	{
		Session session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(NoteLabel.class);
			criteria.add(Restrictions.eq("id", id));
			NoteLabel labels = (NoteLabel) criteria.uniqueResult();
			session.delete(labels);
			return true;
		}
	
	@Override
	public boolean editLabel(NoteLabel label) {
		
		Session session = sessionFactory.getCurrentSession();
			session.update(label);			
			return true;
			
		} 
}
	


*/