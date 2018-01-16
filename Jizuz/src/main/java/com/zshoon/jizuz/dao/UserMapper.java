package com.zshoon.jizuz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zshoon.jizuz.entity.po.UserPo;
import com.zshoon.jizuz.entity.po.UserRolePo;

@Mapper
public interface UserMapper {

	public List<UserPo> findUsers();

	public UserPo findByUserName(String username);

	public UserPo findByUid(int uid);

	public int updateUserByUid4Edit(UserPo po);

	public int updateUserRoleByUid4Edit(UserRolePo upPo);

}
