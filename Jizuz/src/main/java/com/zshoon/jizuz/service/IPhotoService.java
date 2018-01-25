package com.zshoon.jizuz.service;

import java.util.List;

import com.zshoon.jizuz.entity.dto.PThemeDto;
import com.zshoon.jizuz.entity.dto.PhotoDto;

/**
 * 〈图片服务接口〉
 *
 * @author 17081480
 * @since v1.0.0
 */
public interface IPhotoService {
	
	List<PThemeDto> getPhotoThemes();
	
	List<PhotoDto> getPhotosByTid(Long tid);
}
