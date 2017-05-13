package com.server.dao;

import com.server.model.UserModel;

public interface UserDao {
	public void insertUser(UserModel user) throws Exception;
	public void deleteUser(UserModel user) throws Exception;
	public void updateUser(UserModel user) throws Exception;
	public UserModel findUserByName(String username) throws Exception;
}
