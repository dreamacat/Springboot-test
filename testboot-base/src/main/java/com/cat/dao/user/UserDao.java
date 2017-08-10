package com.cat.dao.user;



import com.cat.model.bean.User;

import java.util.Map;

public interface UserDao {

//	public void addUser(User user) throws Exception;
//	public void updateUser(User user) throws Exception;
//	public void deleteUser(Map<String, String> params) throws Exception;
	public User findUserByProperty(Map<String, String> params) throws Exception;
}
