package com.zshoon.jizuz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zshoon.jizuz.entity.po.ArticlePo;

/**
 * 〈ArticleMapper〉
 *
 * @author Jizuz
 * @since v1.0.0
 */
@Mapper
public interface ArticleMapper {

	/**
	 * 〈根据类型获取文章〉
	 *
	 * @param type
	 * @return List
	 * @author 17081480
	 * @since v1.0.0
	 */
	public List<ArticlePo> selectArticlesByType(String type);

	/**
	 * 〈根据id获取文章〉
	 *
	 * @param aid
	 * @return ArticlePo
	 * @author 17081480
	 * @since v1.0.0
	 */
	public ArticlePo selectArticleById(Long aid);

	/**
	 * 〈添加文章〉
	 *
	 * @param po
	 * @return int
	 * @author 17081480
	 * @since v1.0.0
	 */
	public int insertArticle(ArticlePo po);

}
