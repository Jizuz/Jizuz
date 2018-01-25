package com.zshoon.jizuz.entity.dto;

/**
 * 〈PThemeDto〉
 *
 * @author 17081480
 * @since v1.0.0
 */
public class PThemeDto {
	/** 主题id */
	private Long tid;
	/** 主题 */
	private String theme;
	/** 状态 */
	private String state;
	/** 描述 */
	private String comments;

	/**
	 * @return the tid
	 */
	public Long getTid() {
		return tid;
	}

	/**
	 * @param tid
	 *            the tid to set
	 */
	public void setTid(Long tid) {
		this.tid = tid;
	}

	/**
	 * @return the theme
	 */
	public String getTheme() {
		return theme;
	}

	/**
	 * @param theme
	 *            the theme to set
	 */
	public void setTheme(String theme) {
		this.theme = theme;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param comments
	 *            the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}

	/**
	 * 〈功能详细描述〉
	 * 
	 * @return
	 * @author Jizuz
	 * @since v1.0.0
	 */
	@Override
	public String toString() {
		return "PhotoThemeDto [tid=" + tid + ", theme=" + theme + ", state=" + state + ", comments=" + comments + "]";
	}
}
