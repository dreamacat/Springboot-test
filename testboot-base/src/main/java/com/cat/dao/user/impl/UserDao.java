package com.cat.dao.user.impl;

import com.cat.dao.base.impl.MybatisBaseDao;
import com.cat.dao.user.IUserDao;
import com.cat.model.bean.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDao extends MybatisBaseDao implements IUserDao {

	@Override
	public void addUser(User user) throws Exception {
		Map<String,String> map = new HashMap<String,String>();
		insertBySqlId("userMapper.addUser", user);
	}

	@Override
	public void updateUser(User user) throws Exception {
		updateBySqlId("userMapper.updateUser", user);
	}

	@Override
	public void deleteUser(Map<String, String> params) throws Exception {
		deleteBySqlId("userMapper.deleteUser", params);
	}

	@Override
	public User findUserByProperty(Map<String, String> params) throws Exception {
		return findBySqlId("userMapper.findUserByProperty", params,User.class);
	}
}
