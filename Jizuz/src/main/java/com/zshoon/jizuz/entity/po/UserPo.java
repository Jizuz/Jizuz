package com.zshoon.jizuz.entity.po;

import java.util.Date;

/**
 * 〈功能详细描述〉
 *
 * @author Jizuz
 * @since v1.0.0
 */
public class UserPo {

	/**
	 * uid:用户编号
	 */
	private Long uid;

	/**
	 * userName:用户名
	 */
	private String userName;

	/**
	 * fullName:用户全称
	 */
	private String fullName;

	/**
	 * password:用户密码
	 */
	private String password;

	/**
	 * birthday:用户生日
	 */
	private Date birthday;

	/**
	 * sex:用户性别
	 */
	private String sex;

	/**
	 * tel:联系电话
	 */
	private String tel;

	/**
	 * email:电子邮件
	 */
	private String email;

	/**
	 * homeAddr:家庭地址
	 */
	private String homeAddr;

	/**
	 * nowAddr:联系地址
	 */
	private String nowAddr;

	/**
	 * company:公司
	 */
	private String company;

	/**
	 * roles:用户权限
	 */
	private RolePo role;

	/**
	 * @return the uid
	 */
	public Long getUid() {
		return uid;
	}

	/**
	 * @param uid
	 *            the uid to set
	 */
	public void setUid(Long uid) {
		this.uid = uid;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName
	 *            the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday
	 *            the birthday to set
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex
	 *            the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * @param tel
	 *            the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the homeAddr
	 */
	public String getHomeAddr() {
		return homeAddr;
	}

	/**
	 * @param homeAddr
	 *            the homeAddr to set
	 */
	public void setHomeAddr(String homeAddr) {
		this.homeAddr = homeAddr;
	}

	/**
	 * @return the nowAddr
	 */
	public String getNowAddr() {
		return nowAddr;
	}

	/**
	 * @param nowAddr
	 *            the nowAddr to set
	 */
	public void setNowAddr(String nowAddr) {
		this.nowAddr = nowAddr;
	}

	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * @param company
	 *            the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * @return the role
	 */
	public RolePo getRole() {
		return role;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(RolePo role) {
		this.role = role;
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
		return "UserPo [uid=" + uid + ", userName=" + userName + ", fullName=" + fullName + ", password=" + password
				+ ", birthday=" + birthday + ", sex=" + sex + ", tel=" + tel + ", email=" + email + ", homeAddr="
				+ homeAddr + ", nowAddr=" + nowAddr + ", company=" + company + ", role=" + role + "]";
	}

}
