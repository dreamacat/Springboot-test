package com.cat.service.user;

import com.cat.model.bean.User;

import java.util.Map;

public interface IUserService {

	public void addUser(String username, String password, String email, String serverInfo) throws Exception;
	public void updateUser(User user) throws Exception;
	public void deleteUser(Map<String, String> params) throws Exception;
	public User findUserByProperty(Map<String, String> params) throws Exception;

}
