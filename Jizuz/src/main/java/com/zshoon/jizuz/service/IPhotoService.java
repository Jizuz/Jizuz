package com.zshoon.jizuz.service;

import java.util.List;

import com.zshoon.jizuz.entity.dto.PThemeDto;
import com.zshoon.jizuz.entity.dto.PhotoDto;

/**
 * 〈图片服务接口〉
 *
 * @author Jizuz
 * @since v1.0.0
 */
public interface IPhotoService {

	/**
	 * <Description> 选择图片
	 * 
	 * @author Jizuz
	 * @return List
	 */
	List<PThemeDto> getPhotoThemes();

	/**
	 * <Description> 根据主题编号选择图片
	 * 
	 * @author Jizuz
	 * @param tid
	 * @return List
	 */
	List<PhotoDto> getPhotosByTid(Long tid);

	/**
	 * <Description> 插入图片
	 * 
	 * @author Jizuz
	 * @param dto
	 * @return boolean
	 */
	boolean addImage(PhotoDto dto);
}
