package com.wcf.tas.dao.impl;

import org.apache.ibatis.session.SqlSession;

import com.wcf.tas.dao.BaseDAO;
import com.wcf.tas.dao.IUserDAO;
import com.wcf.tas.entity.UserVO;

import java.util.ArrayList;

public class UserDAO extends BaseDAO implements IUserDAO {

	@Override
	public UserVO validateUser(UserVO user) {
		IUserDAO mapper=getSession().getMapper(IUserDAO.class);
		return mapper.validateUser(user);
		
	}

	@Override
	public int addUser(UserVO user) {
		SqlSession session = this.getSession();
		IUserDAO mapper = session.getMapper(IUserDAO.class);
		int num = mapper.addUser(user);
		session.commit();
		session.close();
		return num;
	}

	@Override
	public ArrayList<UserVO> isExistUserByName(String username) {
		IUserDAO mapper=getSession().getMapper(IUserDAO.class);
		return mapper.isExistUserByName(username);
	}

}
