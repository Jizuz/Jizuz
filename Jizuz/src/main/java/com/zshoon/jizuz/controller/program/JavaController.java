package com.zshoon.jizuz.controller.program;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zshoon.jizuz.common.enums.ArticleTypeEnum;
import com.zshoon.jizuz.entity.dto.ArticleDto;
import com.zshoon.jizuz.service.IArticleService;

/**
 * 〈JavaController〉
 *
 * @author 17081480
 * @since v1.0.0
 */
@Controller
public class JavaController {

	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(JavaController.class);

	/**
	 * articleService
	 */
	@Autowired
	private IArticleService articleService;

	@RequestMapping("/java")
	public String toJava(Model model) {
		logger.debug("toJava begin ...");
		model.addAttribute("page", "java");

		List<ArticleDto> dtoList = articleService.getArticlesByType(ArticleTypeEnum.JAVA.getCode());
		model.addAttribute("javaList", dtoList);

		logger.debug("toJava end ...");
		return "common";
	}

}
