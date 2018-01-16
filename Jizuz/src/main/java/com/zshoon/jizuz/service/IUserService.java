package com.zshoon.jizuz.service;

import java.util.List;

import com.zshoon.jizuz.entity.dto.UserDto;

public interface IUserService {

	public List<UserDto> findUsers();

	public UserDto findUserByUserName(String username);

	public UserDto findUserBuUid(int uid);

}
