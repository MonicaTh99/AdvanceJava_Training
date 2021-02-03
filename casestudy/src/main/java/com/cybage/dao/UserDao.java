package com.cybage.dao;

import java.sql.SQLException;
import java.util.List;

import com.cybage.model.User;

public interface UserDao {
	public int addUer(User user) throws Exception;
	public List<User> findUser() throws Exception;
	public User findUserById(int id) throws Exception;
	public int deleteUser(int id) throws Exception;
	public int udpateUser(User user) throws Exception;
}
