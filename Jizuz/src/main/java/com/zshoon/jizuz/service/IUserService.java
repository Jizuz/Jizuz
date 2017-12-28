package com.zshoon.jizuz.service;

import com.zshoon.jizuz.entity.UserDto;

public interface IUserService {
	
	public UserDto findUserByUserName(String username);
	
}
