package com.wcf.tas.dao;

import com.wcf.tas.entity.UserVO;

import java.util.ArrayList;

public interface IUserDAO {
	

	public UserVO validateUser(UserVO user);
	public int addUser(UserVO user);
	public ArrayList<UserVO> isExistUserByName(String username);
}
