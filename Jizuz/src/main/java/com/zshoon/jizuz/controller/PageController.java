package com.zshoon.jizuz.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zshoon.jizuz.common.utils.CommonUtil;
import com.zshoon.jizuz.entity.UserDto;
import com.zshoon.jizuz.service.IUserService;

@Controller
public class PageController {
	
	@Autowired
	private IUserService userService;

	@RequestMapping("/")
	public String def(Model model) {
		model.addAttribute("page", "index");
		return "common";
	}

	@RequestMapping("/index")
	public String toIndex(Model model) {
		model.addAttribute("page", "index");
		return "common";
	}

	@RequestMapping("/java")
	public String toJava(Model model) {
		model.addAttribute("page", "java");
		return "common";
	}
	
	@RequestMapping("/memberMgt")
	public String toMemberMgt(Model model) {
		List<UserDto> userList = userService.findUsers();
		if (CommonUtil.isEmpty(userList)) {
			model.addAttribute("users", new ArrayList<UserDto>());
		} else {
			model.addAttribute("users", userList);
		}
		model.addAttribute("page", "memberMgt");
		return "common";
	}

}
