/*package com.bridgelabz.User.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bridgelabz.User.DAO.LabelDao;
import com.bridgelabz.User.model.NoteLabel;
import com.bridgelabz.User.model.User;


@Service
public class LabelServiceImp implements LabelService {

	@Autowired 
	LabelDao labelDao;


	@Transactional
	public void addLabel(NoteLabel label) {

		labelDao.addLabel(label);
	}

	@Transactional
	public NoteLabel getLabelByName(String labelName)
	{
		return labelDao.getLabelByName(labelName);
	}

	@Transactional
	public List<NoteLabel> getLabels(User user)
	{
		return labelDao.getLabels(user);
	}

	@Transactional
	public boolean deleteLabelById(int id) {
		labelDao.deletelabelById(id);
		return true;
	}
	
	@Transactional
	public boolean editLabel(NoteLabel label) {
		labelDao.editLabel(label);
		return true;
	}
}







*/