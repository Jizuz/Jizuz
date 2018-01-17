package com.zshoon.jizuz.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.zshoon.jizuz.common.utils.DateUtil;
import com.zshoon.jizuz.dao.TimeAxisMapper;
import com.zshoon.jizuz.entity.dto.TimeAxisDto;
import com.zshoon.jizuz.entity.po.TimeAxisPo;
import com.zshoon.jizuz.service.ITimeAxisService;

/**
 * 〈功能详细描述〉
 *
 * @author Jizuz
 * @since v1.0.0
 */
@Service("timeAxisService")
public class TimeAxisService implements ITimeAxisService {

	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(TimeAxisService.class);

	/**
	 * taMapper
	 */
	@Resource
	private TimeAxisMapper taMapper;

	/**
	 * @author Jizuz
	 */
	@Override
	public List<TimeAxisDto> findTimeAxis() {
		List<TimeAxisPo> poList = new ArrayList<>();
		try {
			poList = taMapper.selectTimeAxis();
		} catch (Exception e) {
			logger.debug("", e);
			poList = null;
		}

		List<TimeAxisDto> dtoList = new ArrayList<>();
		for (TimeAxisPo po : poList) {
			TimeAxisDto dto = new TimeAxisDto();
			BeanUtils.copyProperties(po, dto);
			String dateTime = DateUtil.date2String(po.getTimePoint(), DateUtil.DATE_FORMAT_1);
			dto.setTimePoint(dateTime);
			dtoList.add(dto);
		}

		return dtoList;
	}

}
