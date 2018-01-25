package com.zshoon.jizuz.entity.po;

import java.util.Date;

/**
 * 〈图片PO〉
 *
 * @author Jizuz
 * @since v1.0.0
 */
public class PhotoPo {

	/**
	 * oid:图片编号
	 */
	private Long oid;

	/**
	 * theme:主题
	 */
	private Long tid;

	/**
	 * path:存储路径
	 */
	private String path;

	/**
	 * author:图片作者
	 */
	private String author;

	/**
	 * date:拍摄日期
	 */
	private Date date;

	/**
	 * comments:描述
	 */
	private String comments;

	/**
	 * @return the oid
	 */
	public Long getOid() {
		return oid;
	}

	/**
	 * @param oid
	 *            the oid to set
	 */
	public void setOid(Long oid) {
		this.oid = oid;
	}

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
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path
	 *            the path to set
	 */
	public void setPath(String path) {
		this.path = path;
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
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
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
		return "PhotoPo [oid=" + oid + ", tid=" + tid + ", path=" + path + ", author=" + author + ", date=" + date
				+ ", comments=" + comments + "]";
	}

}
