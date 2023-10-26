package com.wcf.tas.service.impl;

import org.springframework.stereotype.Service;

import com.wcf.tas.dao.impl.UserDAO;
import com.wcf.tas.entity.UserVO;
import com.wcf.tas.service.IUserService;

import java.util.ArrayList;


@Service
public class UserService implements IUserService {
	
	private UserDAO userDAO;
	
	@Override
	public UserVO validateUser(UserVO user) {
		return userDAO.validateUser(user);
	}

	@Override
	public int regUser(UserVO user) {
		return userDAO.addUser(user);
	}

	@Override
	public boolean isExistUserByName(String username) {
		ArrayList<UserVO> userList=userDAO.isExistUserByName(username);
		if(userList.size()>0) {
			return true;
		}

		return false;
	}


	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
