package com.cybage.service;

import java.util.List;

import com.cybage.model.User;

public interface UserService {
	public int addUer(User user) throws Exception;
	public List<User> findUser() throws Exception;
	public User findUserById(int id) throws Exception;
	public int deleteUser(int id) throws Exception;
	public int udpateUser(User user) throws Exception;
}
