/*
 * Copyright (C), 2018-2018, Jizuz
 * FileName: TimeAxisMapper.java
 * Author:   Jizuz
 * Date:     2018年1月17日 上午9:19:19
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.zshoon.jizuz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zshoon.jizuz.entity.po.TimeAxisPo;

/**
 * 〈TimeAxisMapper〉
 *
 * @author Jizuz
 * @since v1.0.0
 */
@Mapper
public interface TimeAxisMapper {

	public List<TimeAxisPo> selectTimeAxis();

}
