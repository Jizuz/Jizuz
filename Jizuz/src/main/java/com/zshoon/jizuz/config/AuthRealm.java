package com.zshoon.jizuz.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.zshoon.jizuz.entity.dto.PermissionDto;
import com.zshoon.jizuz.entity.dto.RoleDto;
import com.zshoon.jizuz.entity.dto.UserDto;
import com.zshoon.jizuz.service.IUserService;

/**
 * 〈功能详细描述〉
 *
 * @author Jizuz
 * @since v1.0.0
 */
public class AuthRealm extends AuthorizingRealm {

	@Autowired
	private IUserService userService;

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) throws AuthenticationException {
		UserDto user = (UserDto) principal.fromRealm(this.getClass().getName()).iterator().next();// 获取session中的用户
		List<String> permissions = new ArrayList<>();
		RoleDto role = user.getRole();
		if (role != null) {
			Set<PermissionDto> modules = role.getPermissions();
			if (modules.size() > 0) {
				for (PermissionDto module : modules) {
					permissions.add(module.getPermissionName());
				}
			}
		}

		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		// 将权限放入shiro中.
		info.addStringPermissions(permissions);
		return info;
	}

	/**
	 * 认证、登录
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 获取用户输入的token
		UsernamePasswordToken utoken = (UsernamePasswordToken) token;
		String username = utoken.getUsername();
		UserDto user = userService.findUserByUserName(username);
		// 放入shiro.调用CredentialsMatcher检验密码
		return new SimpleAuthenticationInfo(user, user.getPassword(), this.getClass().getName());
	}

}
