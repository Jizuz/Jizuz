package com.zshoon.jizuz.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zshoon.jizuz.common.utils.CommonUtil;
import com.zshoon.jizuz.entity.dto.UserDto;
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
	
	@RequestMapping("/py")
	public String toPy(Model model) {
		model.addAttribute("page", "py");
		return "common";
	}
	
	@RequestMapping("/php")
	public String toPhp(Model model) {
		model.addAttribute("page", "php");
		return "common";
	}
	
	@RequestMapping("/webgl")
	public String toWebGL(Model model) {
		model.addAttribute("page", "webgl");
		return "common";
	}
	
	@RequestMapping("/front")
	public String toFront(Model model) {
		model.addAttribute("page", "front");
		return "common";
	}
	
	@RequestMapping("/problem")
	public String toProblem(Model model) {
		model.addAttribute("page", "problem");
		return "common";
	}
	
	@RequestMapping("/skills")
	public String toSkill(Model model) {
		model.addAttribute("page", "skills");
		return "common";
	}
	
	@RequestMapping("/photo")
	public String toPhoto(Model model) {
		model.addAttribute("page", "photo");
		return "common";
	}
	
	@RequestMapping("/ps")
	public String toPs(Model model) {
		model.addAttribute("page", "ps");
		return "common";
	}
	
	@RequestMapping("/ae")
	public String toAe(Model model) {
		model.addAttribute("page", "ae");
		return "common";
	}
	
	@RequestMapping("/pr")
	public String toPr(Model model) {
		model.addAttribute("page", "pr");
		return "common";
	}
	
	@RequestMapping("/max")
	public String toMax(Model model) {
		model.addAttribute("page", "max");
		return "common";
	}
	
	@RequestMapping("/football")
	public String toFootball(Model model) {
		model.addAttribute("page", "football");
		return "common";
	}
	
	@RequestMapping("/think")
	public String toThink(Model model) {
		model.addAttribute("page", "think");
		return "common";
	}
	
	@RequestMapping("/times")
	public String toTimes(Model model) {
		model.addAttribute("page", "times");
		return "common";
	}
	
	@RequestMapping("/about")
	public String toAbout(Model model) {
		model.addAttribute("page", "about");
		return "common";
	}
	
	@RequestMapping("/words")
	public String toWords(Model model) {
		model.addAttribute("page", "words");
		return "common";
	}
	
	@RequestMapping("/profile")
	public String toProfile(Model model) {
		model.addAttribute("page", "profile");
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

	@RequestMapping("/articleMgt")
	public String toArticleMgt(Model model) {
		model.addAttribute("page", "articleMgt");
		return "common";
	}
}
