package com.entity;

public class SumCourse {
	
	
	@Override
	public String toString() {
		return "SumCourse [code=" + code + ", createTime=" + createTime
				+ ", id=" + id + ", isCheck=" + isCheck + ", name=" + name
				+ ", realName=" + realName + ", teacherCode=" + teacherCode
				+ ", teacherName=" + teacherName + ", usercode=" + usercode
				+ "]";
	}

	private Integer id;
	
	private String code;
	
	private String name;
	
	private String usercode;
	
	private String realName;
	
	private String createTime;
	
	private String isCheck;
	
	private String teacherCode;
	
	private String teacherName;

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

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getIsCheck() {
		return isCheck;
	}

	public void setIsCheck(String isCheck) {
		this.isCheck = isCheck;
	}

	public String getTeacherCode() {
		return teacherCode;
	}

	public void setTeacherCode(String teacherCode) {
		this.teacherCode = teacherCode;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	
	
	

}
