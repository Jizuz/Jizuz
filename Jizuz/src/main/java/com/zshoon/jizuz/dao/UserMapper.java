package com.zshoon.jizuz.dao;

import org.apache.ibatis.annotations.Mapper;

import com.zshoon.jizuz.entity.UserDto;

@Mapper
public interface UserMapper {

	public UserDto findByUserName(String username);

}
