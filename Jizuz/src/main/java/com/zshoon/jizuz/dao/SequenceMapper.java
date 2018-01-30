package com.zshoon.jizuz.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 〈序列号数据操作〉
 *
 * @author 17081480
 * @since v1.0.0
 */
@Mapper
public interface SequenceMapper {

	/**
	 * 〈获取表新的id〉
	 *
	 * @param map Map
	 * @return Long
	 * @author 17081480
	 * @since v1.0.0
	 */
	@Select("select max(${columnName})+1 from ${tableName} where 1=1")
	public Long selectNewId(Map<String, String> map);
}
