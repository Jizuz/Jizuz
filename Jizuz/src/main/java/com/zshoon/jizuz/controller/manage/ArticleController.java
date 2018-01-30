package com.zshoon.jizuz.controller.manage;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.zshoon.jizuz.entity.dto.ArticleDto;
import com.zshoon.jizuz.entity.dto.UserDto;
import com.zshoon.jizuz.service.IArticleService;

/**
 * 〈文章管理controller〉
 *
 * @author Jizuz
 * @since v1.0.0
 */
@Controller
public class ArticleController {

	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);

	/**
	 * articleService
	 */
	@Autowired
	private IArticleService articleService;

	/**
	 * 〈添加文章内容〉
	 *
	 * @param request
	 * @return String
	 * @author Jizuz
	 * @since v1.0.0
	 */
	@ResponseBody
	@RequestMapping("/addArticle")
	public String addArticle(HttpServletRequest request) {
		logger.debug("add article begin ...");

		UserDto user = (UserDto) SecurityUtils.getSubject().getSession().getAttribute("user");
		ArticleDto artcDto = new ArticleDto();
		artcDto.setAuthor(user.getUserName());
		artcDto.setType(request.getParameter("artcType"));
		artcDto.setTitle(request.getParameter("artcTitle"));
		artcDto.setContent(request.getParameter("artcContent"));

		boolean retFlag = articleService.addArticle(artcDto);

		logger.debug("add article end ...");
		return (retFlag) ? JSON.toJSONString("success") : "error";
	}

}
