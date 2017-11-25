package com.bridgelabz.User.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bridgelabz.User.DAO.UserDao;
import com.bridgelabz.User.model.User;

@Service
@Transactional
public class UserServiceImplemention implements UserService {

	@Autowired
	UserDao userDao;

	public int createUser(User user) {
		int found = userDao.registration(user);
		if (found==1)
			return found;
		else
			return found;
	}

	public User loginUser(User user) {
		return userDao.login(user);
	}
	public User getUserByEmail(String email) {
		User result =  userDao.getUserByEmail(email);
		return result;
	}

	public User getUserById(int id) {
		return userDao.getUserById(id);
	}

	public boolean updateActivation(int id) {
		return userDao.updateActivation(id);
	}
	@Override
	public void updateUser(User oldUser) {
		userDao.updateUser(oldUser);
}
}