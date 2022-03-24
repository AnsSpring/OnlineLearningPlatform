package com.entity;

/***
 * 登录用户的角色，登录名唯一
 * @author Administrator
 *
 */
public class LoginUser {
	
	
    
	@Override
	public String toString() {
		return "LoginUser [id=" + id + ", realName=" + realName + ", role="
				+ role + ", roleValue=" + roleValue + ", usercode=" + usercode
				+ ", username=" + username + "]";
	}

	private Integer id;
	
	private String usercode;

	private String username;

	private Integer role;
	
	private String roleValue;
	
	private String  realName;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public String getRoleValue() {
		return roleValue;
	}

	public void setRoleValue(String roleValue) {
		this.roleValue = roleValue;
	}

}
