package com.zshoon.jizuz.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;

import com.zshoon.jizuz.common.utils.CommonUtil;
import com.zshoon.jizuz.common.utils.DateUtil;
import com.zshoon.jizuz.dao.PhotoMapper;
import com.zshoon.jizuz.entity.dto.PThemeDto;
import com.zshoon.jizuz.entity.dto.PhotoDto;
import com.zshoon.jizuz.entity.po.PhotoPo;
import com.zshoon.jizuz.service.IPhotoService;

/**
 * 〈图片服务接口〉
 *
 * @author 17081480
 * @since v1.0.0
 */
@Service("photoService")
public class PhotoService implements IPhotoService {

	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(PhotoService.class);

	/**
	 * mapper
	 */
	@Resource
	private PhotoMapper mapper;

	@Override
	public List<PThemeDto> getPhotoThemes() {
		List<PThemeDto> dtoList = new ArrayList<>();
		try {
			dtoList = mapper.selectPThemesNoSystem();
		} catch (Exception e) {
			logger.error("数据库操作错误，{}", e);
			dtoList = null;
		}
		return dtoList;
	}

	@Override
	public List<PhotoDto> getPhotosByTid(Long tid) {
		List<PhotoDto> dtoList = new ArrayList<>();
		try {
			List<PhotoPo> poList = mapper.selectPhotosByTid(tid);
			// po列表对象转换成dto列表对象
			po2Dto(dtoList, poList);
		} catch (Exception e) {
			logger.error("数据库操作错误，{}", e);
			dtoList = null;
		}
		return dtoList;
	}

	/**
	 * 〈po列表对象转换成dto列表对象〉
	 *
	 * @param dtoList
	 * @param poList
	 * @throws BeansException
	 * @author 17081480
	 * @since v1.0.0
	 */
	private void po2Dto(List<PhotoDto> dtoList, List<PhotoPo> poList) throws BeansException {
		if (CommonUtil.isNotEmpty(poList)) {
			for (PhotoPo po : poList) {
				PhotoDto dto = new PhotoDto();
				BeanUtils.copyProperties(po, dto);
				String dateStr = DateUtil.date2String(po.getDate(), DateUtil.DATE_FORMAT_1);
				dto.setDate(dateStr);
				dtoList.add(dto);
			}
		}
	}

}
