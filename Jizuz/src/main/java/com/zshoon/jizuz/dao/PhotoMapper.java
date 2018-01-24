package com.zshoon.jizuz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zshoon.jizuz.entity.po.PhotoPo;

/**
 * 〈PhotoMapper〉
 *
 * @author Jizuz
 * @since v1.0.0
 */
@Mapper
public interface PhotoMapper {

	public List<PhotoPo> selectPhotos();
	
	public List<PhotoPo> selectPhotosNoSystem();
	
	public List<PhotoPo> selectPhotosByTid(Long tid);
	
	public List<PhotoPo> selectPhotosByAuthor(String author);
	
}
