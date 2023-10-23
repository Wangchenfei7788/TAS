package com.wcf.tas.dao.impl;

import org.apache.ibatis.session.SqlSession;

import com.wcf.tas.dao.BaseDAO;
import com.wcf.tas.dao.IUserDAO;
import com.wcf.tas.entity.UserVO;

public class UserDAO extends BaseDAO implements IUserDAO {

	@Override
	public UserVO validateUser(UserVO user) {
		IUserDAO mapper=getSession().getMapper(IUserDAO.class);
		return mapper.validateUser(user);
		
	}

}
