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
 * <Description> WebGLController
 * 
 * @author Jizuz
 * @version V1.0
 * @CreateDate 2018年2月3日
 * @since V1.0
 * @see com.zshoon.jizuz.controller.program
 */
@Controller
public class WebGLController {

	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(WebGLController.class);

	/**
	 * articleService
	 */
	@Autowired
	private IArticleService articleService;

	/**
	 * <Description> 跳转webgl页
	 * 
	 * @author Jizuz
	 * @param model
	 * @return String
	 */
	@RequestMapping("/webgl")
	public String toWebGL(Model model) {
		logger.debug("toWebgl begin ...");
		model.addAttribute("page", "webgl");

		List<ArticleDto> dtoList = articleService.getArticlesByType(ArticleTypeEnum.WEBGL.getCode());
		model.addAttribute("webglList", dtoList);

		logger.debug("toWebgl end ...");
		return "common";
	}
}
