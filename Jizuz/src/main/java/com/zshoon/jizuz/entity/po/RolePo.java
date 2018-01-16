package com.zshoon.jizuz.entity.po;

import java.util.Set;

/**
 * 〈功能详细描述〉
 *
 * @author Jizuz
 * @since v1.0.0
 */
public class RolePo {

	/**
	 * rid
	 */
	private Long rid;

	/**
	 * roleName
	 */
	private String roleName;

	/**
	 * comments
	 */
	private String comments;

	/**
	 * users
	 */
	private Set<UserPo> users;

	/**
	 * permissions
	 */
	private Set<PermissionPo> permissions;

	/**
	 * @return the rid
	 */
	public Long getRid() {
		return rid;
	}

	/**
	 * @param rid
	 *            the rid to set
	 */
	public void setRid(Long rid) {
		this.rid = rid;
	}

	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName
	 *            the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
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
	 * @return the users
	 */
	public Set<UserPo> getUsers() {
		return users;
	}

	/**
	 * @param users
	 *            the users to set
	 */
	public void setUsers(Set<UserPo> users) {
		this.users = users;
	}

	/**
	 * @return the permissions
	 */
	public Set<PermissionPo> getPermissions() {
		return permissions;
	}

	/**
	 * @param permissions
	 *            the permissions to set
	 */
	public void setPermissions(Set<PermissionPo> permissions) {
		this.permissions = permissions;
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
		return "RolePo [rid=" + rid + ", roleName=" + roleName + ", comments=" + comments + ", users=" + users
				+ ", permissions=" + permissions + "]";
	}

}
