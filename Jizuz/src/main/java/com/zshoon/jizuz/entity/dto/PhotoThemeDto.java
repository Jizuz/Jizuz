package com.zshoon.jizuz.entity.dto;

import java.util.List;

/**
 * 〈PhotoThemeDTO〉
 *
 * @author 17081480
 * @since v1.0.0
 */
public class PhotoThemeDto {
	/** 主题id */
	private Long tid;
	/** 主题 */
	private String theme;
	/** 状态 */
	private List<PhotoDto> photoList;
	/**
	 * @return the tid
	 */
	public Long getTid() {
		return tid;
	}
	/**
	 * @param tid the tid to set
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
	 * @param theme the theme to set
	 */
	public void setTheme(String theme) {
		this.theme = theme;
	}
	/**
	 * @return the photoList
	 */
	public List<PhotoDto> getPhotoList() {
		return photoList;
	}
	/**
	 * @param photoList the photoList to set
	 */
	public void setPhotoList(List<PhotoDto> photoList) {
		this.photoList = photoList;
	}
	/**
	 * 〈功能详细描述〉
	 * @return
	 * @author Jizuz
	 * @since v1.0.0
	 */
	@Override
	public String toString() {
		return "PhotoThemeDto [tid=" + tid + ", theme=" + theme + ", photoList=" + photoList + "]";
	}

	
}
