package com.zshoon.jizuz.service;

import java.util.List;

import com.zshoon.jizuz.entity.UserDto;

public interface IUserService {
	
	public List<UserDto> findUsers();
	
	public UserDto findUserByUserName(String username);
	
}
