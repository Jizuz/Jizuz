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

@Controller
public class LoginController {

	@RequestMapping("login")
	public String loginSys(Model model) {
		return "login";
	}

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
