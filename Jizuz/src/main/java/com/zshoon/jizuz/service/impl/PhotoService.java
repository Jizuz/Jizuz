package com.zshoon.jizuz.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;

import com.zshoon.jizuz.common.helper.SequenceHelper;
import com.zshoon.jizuz.common.utils.CommonUtil;
import com.zshoon.jizuz.common.utils.DateUtil;
import com.zshoon.jizuz.dao.PhotoMapper;
import com.zshoon.jizuz.entity.dto.PThemeDto;
import com.zshoon.jizuz.entity.dto.PhotoDto;
import com.zshoon.jizuz.entity.dto.UserDto;
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

	/**
	 * <Description> 根据图片主题
	 * 
	 * @author Jizuz
	 * @return List
	 */
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

	/**
	 * <Description> 根据主题id查询图片
	 * 
	 * @author Jizuz
	 * @param tid
	 * @return List
	 */
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

	/**
	 * <Description> 添加图片
	 * 
	 * @author Jizuz
	 * @param dto
	 * @return boolean
	 */
	@Override
	public boolean addImage(PhotoDto dto) {
		String dateStr = DateUtil.date2String(new Date(), DateUtil.DATE_FORMAT_1);
		UserDto user = (UserDto) SecurityUtils.getSubject().getSession().getAttribute("user");
		// 获取新的id
		Long id = SequenceHelper.generateId("oid", "t_photo");

		PhotoPo po = new PhotoPo();
		BeanUtils.copyProperties(dto, po);
		po.setDate(DateUtil.string2Date(dateStr, DateUtil.DATE_FORMAT_1));
		po.setAuthor(user.getUserName());
		po.setOid(id);

		try {
			int ret = mapper.insertPhoto(po);
			if (ret > 0) {
				return true;
			}
		} catch (Exception e) {
			logger.error("数据库操作错误，{}", e);
		}

		return false;
	}

}
