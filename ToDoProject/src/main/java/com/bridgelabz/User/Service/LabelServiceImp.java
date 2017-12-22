package com.bridgelabz.User.Service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bridgelabz.User.DAO.LabelDao;
import com.bridgelabz.User.model.NoteLabel;


@Service
public class LabelServiceImp implements LabelService {
	
	@Autowired 
	LabelDao labelDao;
	

	@Transactional
	public void addLabel(NoteLabel label) {
		
		labelDao.addLabel(label);
	}

/*	public boolean deleteLable(NoteLabel label) {
		return userDao.deleteLable(label);
	}

	public boolean updateLable(NoteLabel label) {
		// TODO Auto-generated method stub
		return userDao.updateLable(label);
	}

	public Set<NoteLabel> getAllLabels(int userId) {
		// TODO Auto-generated method stub
		return userDao.getAllLabels(userId);
	}


	public List<UserDetails> getUserList() {
		
		return userDao.getUserList();*/
	}

	
}
