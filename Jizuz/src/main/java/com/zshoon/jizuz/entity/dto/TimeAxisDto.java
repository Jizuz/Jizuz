package com.zshoon.jizuz.entity.dto;

/**
 * 〈时间轴DTO〉
 *
 * @author Jizuz
 * @since v1.0.0
 */
public class TimeAxisDto {

	private Long id;

	private String title;

	private String content;

	private String author;

	private String timePoint;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author
	 *            the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the timePoint
	 */
	public String getTimePoint() {
		return timePoint;
	}

	/**
	 * @param timePoint
	 *            the timePoint to set
	 */
	public void setTimePoint(String timePoint) {
		this.timePoint = timePoint;
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
		return "TimeAxisPo [id=" + id + ", title=" + title + ", content=" + content + ", author=" + author
				+ ", timePoint=" + timePoint + "]";
	}

}
