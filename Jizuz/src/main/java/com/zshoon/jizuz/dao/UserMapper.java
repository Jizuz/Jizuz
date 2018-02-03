package com.zshoon.jizuz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zshoon.jizuz.entity.po.UserPo;
import com.zshoon.jizuz.entity.po.UserRolePo;

/**
 * <Description> UserMapper
 * 
 * @author Jizuz
 * @version V1.0
 * @CreateDate 2018年2月3日
 * @since V1.0
 * @see com.zshoon.jizuz.dao
 */
@Mapper
public interface UserMapper {

	/**
	 * <Description> 查询用户
	 * 
	 * @author Jizuz
	 * @return List
	 */
	public List<UserPo> findUsers();

	/**
	 * <Description> 根据用户名查询用户
	 * 
	 * @author Jizuz
	 * @param username
	 * @return UserPo
	 */
	public UserPo findByUserName(String username);

	/**
	 * <Description> 根据用户id查询用户
	 * 
	 * @author Jizuz
	 * @param uid
	 * @return UserPo
	 */
	public UserPo findByUid(int uid);

	/**
	 * <Description> 更新用户
	 * 
	 * @author Jizuz
	 * @param po
	 * @return int
	 */
	public int updateUserByUid4Edit(UserPo po);

	/**
	 * <Description> 更新用户角色
	 * 
	 * @author Jizuz
	 * @param upPo
	 * @return int
	 */
	public int updateUserRoleByUid4Edit(UserRolePo upPo);

}
