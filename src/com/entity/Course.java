package com.entity;

public class Course {
	

	@Override
	public String toString() {
		return "Course [code=" + code + ", createTime=" + createTime + ", id="
				+ id + ", isCheck=" + isCheck + ", name=" + name
				+ ", realName=" + realName + ", usercode=" + usercode + "]";
	}

	private Integer id;
	
	private String code;
	
	private String name;
	
	private String usercode;
	
	private String realName;
	
	private String isCheck;
	
	private String createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getIsCheck() {
		return isCheck;
	}

	public void setIsCheck(String isCheck) {
		this.isCheck = isCheck;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	
}
