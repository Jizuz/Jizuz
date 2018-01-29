package com.zshoon.jizuz.service;

import java.util.List;

import com.zshoon.jizuz.entity.dto.ArticleDto;

/**
 * 〈文章管理接口〉
 *
 * @author 17081480
 * @since v1.0.0
 */
public interface IArticleService {

	public List<ArticleDto> getArticlesByType(String type);

	public ArticleDto getArticleById(Long id);

}
