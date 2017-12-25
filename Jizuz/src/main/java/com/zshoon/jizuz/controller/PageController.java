package com.zshoon.jizuz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
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

}
