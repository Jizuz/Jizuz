package com.zshoon.jizuz.service;

import java.util.List;

import com.zshoon.jizuz.entity.dto.UserDto;
import com.zshoon.jizuz.entity.po.RolePo;
import com.zshoon.jizuz.entity.po.UserPo;

public interface IUserService {

	public List<UserDto> findUsers();

	public UserDto findUserByUserName(String username);

	public UserDto findUserBuUid(int uid);

	public void updateUserAndRole(UserPo userPo, RolePo rolePo);

}
