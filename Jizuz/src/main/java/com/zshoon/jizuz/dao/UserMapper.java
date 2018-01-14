package com.zshoon.jizuz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zshoon.jizuz.entity.UserDto;

@Mapper
public interface UserMapper {
	
	public List<UserDto> findUsers();

	public UserDto findByUserName(String username);
	
	public UserDto findByUid(int uid);

}
