package com.cybage.service;

import java.util.List;

import com.cybage.dao.UserDao;
import com.cybage.model.User;

public class UserServiceImpl implements UserService{

	private UserDao userDao;
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	
	private int generateId() {		
		return (int)Math.round(Math.random()*99999);
	}
	
	public int addUer(User user) throws Exception{
		user.setId(generateId());
		return userDao.addUer(user);
	}

	public List<User> findUser() throws Exception{
		return userDao.findUser();
	}

	public int deleteUser(int id) throws Exception {		
		return userDao.deleteUser(id);
	}

	
	public User findUserById(int id) throws Exception {		
		return userDao.findUserById(id);
	}
	public int udpateUser(User user) throws Exception {		
		return userDao.udpateUser(user);
	}

}
