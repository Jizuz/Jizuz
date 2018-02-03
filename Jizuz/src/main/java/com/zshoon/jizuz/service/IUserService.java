package com.zshoon.jizuz.service;

import java.util.List;

import com.zshoon.jizuz.entity.dto.UserDto;
import com.zshoon.jizuz.entity.po.RolePo;
import com.zshoon.jizuz.entity.po.UserPo;

public interface IUserService {

	/**
	 * <Description> 查询用户
	 * 
	 * @author Jizuz
	 * @return List
	 */
	public List<UserDto> findUsers();

	/**
	 * <Description> 根据用户名查询用户
	 * 
	 * @author Jizuz
	 * @param username
	 * @return UserDto
	 */
	public UserDto findUserByUserName(String username);

	/**
	 * <Description> 根据用户id查询用户
	 * 
	 * @author Jizuz
	 * @param uid
	 * @return UserDto
	 */
	public UserDto findUserBuUid(int uid);

	/**
	 * <Description> 更新用户和角色信息
	 * 
	 * @author Jizuz
	 * @param userPo
	 * @param rolePo
	 */
	public void updateUserAndRole(UserPo userPo, RolePo rolePo);

}
