package com.zshoon.jizuz.entity;

import com.zshoon.jizuz.common.constants.CommonMessageCode;

/**
 * 〈公共返回消息〉
 *
 * @author Jizuz
 * @since v1.0.0
 */
public class MessageBo {

	/** 返回码 */
	private String code;

	/** 返回内容 */
	private String content = "";

	/** obj类型 */
	private Object objContent;

	/**
	 * MessageBo
	 */
	public MessageBo() {
		this.code = CommonMessageCode.COMMON_SUCCESS;
	}

	/**
	 * MessageBo
	 * 
	 * @param code
	 */
	public MessageBo(String code) {
		this.code = code;
	}

	/**
	 * MessageBo
	 * 
	 * @param code
	 * @param content
	 */
	public MessageBo(String code, String content) {
		this.code = code;
		this.content = content;
	}

	/**
	 * MessageBo
	 * 
	 * @param code
	 * @param objContent
	 */
	public MessageBo(String code, Object objContent) {
		this.code = code;
		this.objContent = objContent;
	}

	/**
	 * MessageBo
	 * 
	 * @param code
	 * @param content
	 * @param objContent
	 */
	public MessageBo(String code, String content, Object objContent) {
		this.code = code;
		this.content = content;
		this.objContent = objContent;
	}

	/**
	 * 〈获取返回码〉
	 * 
	 * @return String
	 * @author Jizuz
	 * @since v1.0.0
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 〈设置返回码〉
	 * 
	 * @param code
	 * @author Jizuz
	 * @since v1.0.0
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 〈返回内容〉
	 * 
	 * @return String
	 * @author Jizuz
	 * @since v1.0.0
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 〈返回内容〉
	 * 
	 * @param content
	 * @author Jizuz
	 * @since v1.0.0
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 〈obj类型〉
	 * 
	 * @return Object
	 * @author Jizuz
	 * @since v1.0.0
	 */
	public Object getObjContent() {
		return objContent;
	}

	/**
	 * 〈obj类型〉
	 * 
	 * @param objContent
	 * @author Jizuz
	 * @since v1.0.0
	 */
	public void setObjContent(Object objContent) {
		this.objContent = objContent;
	}
}
