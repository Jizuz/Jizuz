package com.zshoon.jizuz.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zshoon.jizuz.dao.UserMapper;
import com.zshoon.jizuz.entity.UserDto;
import com.zshoon.jizuz.service.IUserService;

@Service
public class UserService implements IUserService {
	
	@Resource
	private UserMapper mapper;
	
	@Override
	public List<UserDto> findUsers() {
		return mapper.findUsers();
	}

	@Override
	public UserDto findUserByUserName(String username) {
		return mapper.findByUserName(username);
	}

	@Override
	public UserDto findUserBuUid(int uid) {
		return mapper.findByUid(uid);
	}
}
