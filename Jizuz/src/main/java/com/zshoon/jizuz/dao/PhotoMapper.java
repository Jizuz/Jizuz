package com.zshoon.jizuz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zshoon.jizuz.entity.dto.PThemeDto;
import com.zshoon.jizuz.entity.po.PhotoPo;

/**
 * 〈PhotoMapper〉
 *
 * @author Jizuz
 * @since v1.0.0
 */
@Mapper
public interface PhotoMapper {

	/**
	 * <Description> 选择图片
	 * 
	 * @author Jizuz
	 * @return List
	 */
	public List<PhotoPo> selectPhotos();

	/**
	 * <Description> 选择非系统图片
	 * 
	 * @author Jizuz
	 * @return List
	 */
	public List<PhotoPo> selectPhotosNoSystem();

	/**
	 * <Description> 根据图片编号选择图片
	 * 
	 * @author Jizuz
	 * @param tid
	 * @return List
	 */
	public List<PhotoPo> selectPhotosByTid(Long tid);

	/**
	 * <Description> 根据拍摄者选择图片
	 * 
	 * @author Jizuz
	 * @param author
	 * @return List
	 */
	public List<PhotoPo> selectPhotosByAuthor(String author);

	/**
	 * <Description> 选择非系统图片主题
	 * 
	 * @author Jizuz
	 * @return List
	 */
	public List<PThemeDto> selectPThemesNoSystem();

	/**
	 * <Description> 插入图片
	 * 
	 * @author Jizuz
	 * @param po
	 * @return int
	 */
	public int insertPhoto(PhotoPo po);

}
