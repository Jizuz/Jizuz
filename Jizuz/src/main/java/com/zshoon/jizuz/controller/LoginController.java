package com.zshoon.jizuz.controller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zshoon.jizuz.entity.dto.UserDto;

/**
 * <Description> LoginController
 * 
 * @author Jizuz
 * @version V1.0
 * @CreateDate 2018年2月3日
 * @since V1.0
 * @see com.zshoon.jizuz.controller
 */
@Controller
public class LoginController {

	/**
	 * <Description> 系统登录
	 * 
	 * @author Jizuz
	 * @param model
	 * @return String
	 */
	@RequestMapping("login")
	public String loginSys(Model model) {
		return "login";
	}

	/**
	 * <Description> 用户登录
	 * 
	 * @author Jizuz
	 * @param username
	 * @param password
	 * @param session
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "/loginUser", method = RequestMethod.POST)
	public String loginUser(String username, String password, HttpSession session, Model model) {
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
		Subject subject = SecurityUtils.getSubject();
		try {
			// 完成登录
			subject.login(usernamePasswordToken);
			UserDto user = (UserDto) subject.getPrincipal();
			session.setAttribute("user", user);
			model.addAttribute("page", "index");
			return "common";
		} catch (Exception e) {
			// 登录异常，返回登录页面重新登录
			return "login";
		}

	}

	/**
	 * <Description> 注销
	 * 
	 * @author Jizuz
	 * @param session
	 * @return String
	 */
	@RequestMapping("/logOut")
	public String logOut(HttpSession session) {
		try {
			Subject subject = SecurityUtils.getSubject();
			subject.logout();
			session.removeAttribute("user");
			return "login";
		} catch (Exception e) {
			return "login";
		}
	}
}
