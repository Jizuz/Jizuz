package com.zshoon.jizuz.controller.manage;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zshoon.jizuz.common.constants.CommonMessageCode;
import com.zshoon.jizuz.entity.MessageBo;
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
	public MessageBo addArticle(HttpServletRequest request) {
		logger.debug("add article begin ...");
		MessageBo msg = new MessageBo();

		UserDto user = (UserDto) SecurityUtils.getSubject().getSession().getAttribute("user");
		ArticleDto artcDto = new ArticleDto();
		artcDto.setAuthor(user.getUserName());
		artcDto.setType(request.getParameter("artcType"));
		artcDto.setTitle(request.getParameter("artcTitle"));
		artcDto.setContent(request.getParameter("artcContent"));

		if (StringUtils.isBlank(request.getParameter("artcTitle"))) {
			msg.setCode(CommonMessageCode.COMMON_ERROR);
			msg.setContent("请输入标题。");
			return msg;
		}

		try {
			boolean retFlag = articleService.addArticle(artcDto);
			if (!retFlag) {
				msg.setCode(CommonMessageCode.COMMON_ERROR);
				msg.setContent("插入文章失败。");
			}
		} catch (Exception e) {
			msg.setCode(CommonMessageCode.COMMON_ERROR);
			msg.setContent("数据库操作错误。");
		}

		logger.debug("add article end ...");
		return msg;
	}

}
