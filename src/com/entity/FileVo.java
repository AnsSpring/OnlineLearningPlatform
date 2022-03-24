package com.entity;

public class FileVo {

	@Override
	public String toString() {
		return "FileVo [address=" + address + ", createTime=" + createTime
				+ ", fileType=" + fileType + ", id=" + id + ", name=" + name
				+ ", pcode=" + pcode + ", pname=" + pname + ", realName="
				+ realName + ", type=" + type + ", usercode=" + usercode + "]";
	}

	private Integer id;
	
	private String name;
	
	private String address;
	
	private String pcode;
	
	private String pname;
	
	private String type;
	
	private String fileType;
	
	private String usercode;
	
	private String realName;
	
	private String createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
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

	

}
