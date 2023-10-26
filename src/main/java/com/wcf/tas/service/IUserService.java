package com.wcf.tas.service;

import com.wcf.tas.entity.UserVO;

public interface IUserService {


	public UserVO validateUser(UserVO user);
	public int regUser(UserVO user);
	public boolean isExistUserByName(String username);
}
