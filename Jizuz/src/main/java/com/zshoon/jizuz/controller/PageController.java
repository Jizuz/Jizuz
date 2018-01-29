package com.zshoon.jizuz.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zshoon.jizuz.entity.dto.ArticleDto;
import com.zshoon.jizuz.service.IArticleService;

@Controller
public class PageController {

	@Autowired
	private IArticleService articleService;

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

	/**
	 * 〈进入文章详情〉
	 *
	 * @param model
	 * @param request
	 * @return String
	 * @author 17081480
	 * @since v1.0.0
	 */
	@RequestMapping("/content")
	public String toContent(Model model, HttpServletRequest request) {
		model.addAttribute("page", "content");
		Long aid = Long.valueOf(request.getParameter("aid"));
		ArticleDto articleDto = articleService.getArticleById(aid);
		model.addAttribute("artc", articleDto);
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

	@RequestMapping("/articleMgt")
	public String toArticleMgt(Model model) {
		model.addAttribute("page", "articleMgt");
		return "common";
	}
}
