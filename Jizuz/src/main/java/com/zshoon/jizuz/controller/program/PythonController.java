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
 * <Description> PythonController
 * 
 * @author Jizuz
 * @version V1.0
 * @CreateDate 2018年2月3日
 * @since V1.0
 * @see com.zshoon.jizuz.controller.program
 */
@Controller
public class PythonController {

	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(PythonController.class);

	/**
	 * articleService
	 */
	@Autowired
	private IArticleService articleService;

	/**
	 * <Description> 跳转python页
	 * 
	 * @author Jizuz
	 * @param model
	 * @return String
	 */
	@RequestMapping("/py")
	public String toPy(Model model) {
		logger.debug("toPy begin ...");
		model.addAttribute("page", "py");

		List<ArticleDto> dtoList = articleService.getArticlesByType(ArticleTypeEnum.PY.getCode());
		model.addAttribute("pyList", dtoList);

		logger.debug("toPy end ...");
		return "common";
	}
}
