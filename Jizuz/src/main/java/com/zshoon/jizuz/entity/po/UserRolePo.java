package com.zshoon.jizuz.entity.po;

public class UserRolePo {

	private Long uid;
	
	private Long rid;
	
	private String state;
	
	private String comments;

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "UserRolePo [uid=" + uid + ", rid=" + rid + ", state=" + state + ", comments=" + comments + "]";
	}
}
