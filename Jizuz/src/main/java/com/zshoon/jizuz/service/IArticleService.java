package com.zshoon.jizuz.service;

import java.util.List;

import com.zshoon.jizuz.entity.dto.ArticleDto;

/**
 * 〈文章管理接口〉
 *
 * @author Jizuz
 * @since v1.0.0
 */
public interface IArticleService {

	/**
	 * 〈根据类型获取文章列表〉
	 *
	 * @param type
	 * @return List
	 * @author Jizuz
	 * @since v1.0.0
	 */
	public List<ArticleDto> getArticlesByType(String type);

	/**
	 * 〈根据id获取文章〉
	 *
	 * @param id
	 * @return ArticleDto
	 * @author Jizuz
	 * @since v1.0.0
	 */
	public ArticleDto getArticleById(Long id);

	/**
	 * 〈新增文章〉
	 *
	 * @param dto
	 * @return boolean
	 * @author Jizuz
	 * @since v1.0.0
	 */
	public boolean addArticle(ArticleDto dto);

}
