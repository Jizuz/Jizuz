package com.zshoon.jizuz.common.helper;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.zshoon.jizuz.common.utils.CommonUtil;

/**
 * 〈帮助类〉
 *
 * @author 17081480
 * @since v1.0.0
 */
public class CommonHelper<T, S> {

	/**
	 * 〈po对象转换成dto对象〉
	 *
	 * @param dtoList
	 * @param poList
	 * @author 17081480
	 * @since v1.0.0
	 */
	public static <T, S> void po2Dto(List<T> dtoList, List<S> poList) {
		if (CommonUtil.isNotEmpty(poList)) {
			for (S po : poList) {
				T dto = null;
				BeanUtils.copyProperties(po, dto);
				dtoList.add(dto);
			}
		}
	}

}
