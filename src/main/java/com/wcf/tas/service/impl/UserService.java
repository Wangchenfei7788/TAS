package com.wcf.tas.service.impl;

import org.springframework.stereotype.Service;

import com.wcf.tas.dao.impl.UserDAO;
import com.wcf.tas.entity.UserVO;
import com.wcf.tas.service.IUserService;


@Service
public class UserService implements IUserService {
	
	private UserDAO userDAO;
	
	@Override
	public UserVO validateUser(UserVO user) {
		// TODO Auto-generated method stub
		return userDAO.validateUser(user);
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
