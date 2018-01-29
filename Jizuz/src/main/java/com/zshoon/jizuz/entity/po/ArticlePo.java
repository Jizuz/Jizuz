package com.zshoon.jizuz.entity.po;

import java.util.Date;

/**
 * 〈功能详细描述〉
 *
 * @author 17081480
 * @since v1.0.0
 */
public class ArticlePo {

	/**
	 * aid
	 */
	private Long aid;

	/**
	 * title
	 */
	private String title;

	/**
	 * content
	 */
	private String content;

	/**
	 * author
	 */
	private String author;

	/**
	 * date
	 */
	private Date date;

	/**
	 * star
	 */
	private int star;

	/**
	 * state
	 */
	private String state;

	/**
	 * type
	 */
	private String type;

	/**
	 * @return the aid
	 */
	public Long getAid() {
		return aid;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @return the star
	 */
	public int getStar() {
		return star;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param aid
	 *            the aid to set
	 */
	public void setAid(Long aid) {
		this.aid = aid;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @param author
	 *            the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @param star
	 *            the star to set
	 */
	public void setStar(int star) {
		this.star = star;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
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
		return "ArticlePo [aid=" + aid + ", title=" + title + ", content=" + content + ", author=" + author + ", date="
				+ date + ", star=" + star + ", state=" + state + ", type=" + type + "]";
	}
}
