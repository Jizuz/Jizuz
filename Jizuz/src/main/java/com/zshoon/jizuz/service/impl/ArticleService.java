package com.zshoon.jizuz.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.zshoon.jizuz.common.constants.CommonConstant;
import com.zshoon.jizuz.common.helper.SequenceHelper;
import com.zshoon.jizuz.common.utils.CommonUtil;
import com.zshoon.jizuz.common.utils.DateUtil;
import com.zshoon.jizuz.dao.ArticleMapper;
import com.zshoon.jizuz.entity.dto.ArticleDto;
import com.zshoon.jizuz.entity.po.ArticlePo;
import com.zshoon.jizuz.service.IArticleService;

/**
 * 〈文章管理接口〉
 *
 * @author Jizuz
 * @since v1.0.0
 */
@Service("articleService")
public class ArticleService implements IArticleService {

	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(ArticleService.class);

	/**
	 * mapper
	 */
	@Resource
	private ArticleMapper mapper;

	@Override
	public List<ArticleDto> getArticlesByType(String type) {
		logger.debug("getArticlesByType begin ...");
		List<ArticleDto> dtoList = new ArrayList<>();

		try {
			List<ArticlePo> poList = mapper.selectArticlesByType(type);
			po2Dto(dtoList, poList);
		} catch (Exception e) {
			logger.error("数据库操作错误，{}", e);
			dtoList = null;
		}
		logger.debug("getArticlesByType end ...");
		return dtoList;
	}

	@Override
	public ArticleDto getArticleById(Long id) {
		ArticleDto dto = new ArticleDto();
		try {
			ArticlePo po = mapper.selectArticleById(id);
			BeanUtils.copyProperties(po, dto);
			String dateStr = DateUtil.date2String(po.getDate(), DateUtil.DATE_FORMAT_1);
			dto.setDate(dateStr);
		} catch (Exception e) {
			logger.error("数据库操作错误，{}", e);
		}
		return dto;
	}

	/**
	 * 〈po列表对象转换成dto列表对象〉
	 *
	 * @param dtoList
	 * @param poList
	 * @author Jizuz
	 * @since v1.0.0
	 */
	private void po2Dto(List<ArticleDto> dtoList, List<ArticlePo> poList) {
		if (CommonUtil.isNotEmpty(poList)) {
			for (ArticlePo po : poList) {
				ArticleDto dto = new ArticleDto();
				BeanUtils.copyProperties(po, dto);
				String dateStr = DateUtil.date2String(po.getDate(), DateUtil.DATE_FORMAT_1);
				dto.setDate(dateStr);
				dtoList.add(dto);
			}
		}
	}

	@Override
	public boolean addArticle(ArticleDto dto) {
		// 当前日期格式化
		String dateStr = DateUtil.date2String(new Date(), DateUtil.DATE_FORMAT_1);
		ArticlePo po = new ArticlePo();
		BeanUtils.copyProperties(dto, po);
		po.setDate(DateUtil.string2Date(dateStr, DateUtil.DATE_FORMAT_1));
		// 获取新的id
		Long id = SequenceHelper.generateId("aid", "t_article");
		po.setAid(id);
		po.setStar(0);
		po.setState(CommonConstant.ACTIVE);

		try {
			int ret = mapper.insertArticle(po);
			if (ret > 0) {
				return true;
			}
		} catch (Exception e) {
			logger.error("数据库操作错误，{}", e);
			throw e;
		}

		return false;
	}

}
