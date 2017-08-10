package com.cat.service.user.impl;

import com.cat.dao.user.UserDao;
import com.cat.model.bean.User;
import com.cat.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {


	@Autowired
	private UserDao userDao;

	@Override
	public void addUser(String username, String password, String email, String serverInfo) throws Exception {

	}

	@Override
	public void updateUser(User user) throws Exception {

	}

	@Override
	public User findUserByProperty(Map<String, String> params) throws Exception {
		User user ;
		try{
			user = userDao.findUserByProperty(params);
		}catch (Exception e){
			throw  new Exception(e);
		}
		return user;
	}

	@Override
	public void deleteUser(Map<String, String> params) throws Exception {

	}

}
