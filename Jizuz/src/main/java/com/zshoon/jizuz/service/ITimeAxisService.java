/*
 * Copyright (C), 2018-2018, Jizuz
 * FileName: ITimeAxisService.java
 * Author:   Jizuz
 * Date:     2018年1月17日 上午9:29:28
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.zshoon.jizuz.service;

import java.util.List;

import com.zshoon.jizuz.entity.dto.TimeAxisDto;

/**
 * 〈时间轴服务〉
 *
 * @author Jizuz
 * @since v1.0.0
 */
public interface ITimeAxisService {
	
	/**
	 * 〈查询时间轴〉
	 *
	 * @return List
	 * @author Jizuz
	 * @since v1.0.0
	 */
	public List<TimeAxisDto> findTimeAxis();
	
}
