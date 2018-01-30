package com.zshoon.jizuz.common.helper;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.zshoon.jizuz.dao.SequenceMapper;

/**
 * 〈序列编号〉
 *
 * @author Jizuz
 * @since v1.0.0
 */
@Component
public class SequenceHelper {

	/**
	 * seqMapper
	 */
	@Resource
	private SequenceMapper seqMapper;

	// 维护SequenceHelper的静态变量
	public static SequenceHelper seqHelper;

	/**
	 * 〈初始化的时候，将注解获取的变量seqMapper赋值给静态变量〉
	 *
	 * @author Jizuz
	 * @since v1.0.0
	 */
	@PostConstruct
	public void init() {
		seqHelper = this;
		seqHelper.seqMapper = this.seqMapper;
	}

	/**
	 * 〈根据表名字段名生成新的id〉
	 *
	 * @param columnName
	 * @param tableName
	 * @return Long
	 * @author Jizuz
	 * @since v1.0.0
	 */
	public static Long generateId(String columnName, String tableName) {
		Map<String, String> reqMap = new HashMap<>();
		reqMap.put("columnName", columnName);
		reqMap.put("tableName", tableName);
		Long id = seqHelper.seqMapper.selectNewId(reqMap);
		if (id == null) {
			id = 1L;
		}
		return id;
	}

}
