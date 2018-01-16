package com.zshoon.jizuz.entity.po;

import java.util.Set;

public class PermissionPo {

	/**
	 * pid
	 */
	private Long pid;

	/**
	 * permissionName
	 */
	private String permissionName;

	/**
	 * comments
	 */
	private String comments;

	/**
	 * roles
	 */
	private Set<RolePo> roles;

	/**
	 * @return the pid
	 */
	public Long getPid() {
		return pid;
	}

	/**
	 * @param pid
	 *            the pid to set
	 */
	public void setPid(Long pid) {
		this.pid = pid;
	}

	/**
	 * @return the permissionName
	 */
	public String getPermissionName() {
		return permissionName;
	}

	/**
	 * @param permissionName
	 *            the permissionName to set
	 */
	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
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
	 * @return the roles
	 */
	public Set<RolePo> getRoles() {
		return roles;
	}

	/**
	 * @param roles
	 *            the roles to set
	 */
	public void setRoles(Set<RolePo> roles) {
		this.roles = roles;
	}

	/**
	 * 〈功能详细描述〉
	 * 
	 * @return String
	 * @author Jizuz
	 * @since v1.0.0
	 */
	@Override
	public String toString() {
		return "PermissionPo [pid=" + pid + ", permissionName=" + permissionName + ", comments=" + comments + ", roles="
				+ roles + "]";
	}

}
