package com.entity;

public class Project {
	

	@Override
	public String toString() {
		return "Project [code=" + code + ", content=" + content
				+ ", createTime=" + createTime + ", id=" + id + ", name="
				+ name + ", teacherName=" + teacherName + ", usercode="
				+ usercode + "]";
	}

	private int id;
	
	private String code;
	
	private String name;
	
	private String usercode;
	
	private String teacherName;
	
	private String content;
	
	private String createTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	
}
