package com.zshoon.jizuz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zshoon.jizuz.entity.po.ArticlePo;

/**
 * 〈ArticleMapper〉
 *
 * @author 17081480
 * @since v1.0.0
 */
@Mapper
public interface ArticleMapper {

	public List<ArticlePo> selectArticlesByType(String type);

	public ArticlePo selectArticleById(Long aid);

}
