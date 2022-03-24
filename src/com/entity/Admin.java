package com.entity;

public class Admin {
	
	//登录的id
	private int id;
	
	//用户编码
	private String usercode;
	
	//用户名
	private String username;
	
	//密码
	private String password;
	
	//用户角色
	private String role;
	
	//用户的真实姓名
	private String realName;

	//年级和班级
	private String classAndGrade;
	
	//性别
	private String sex;
	
	//年龄
	private String age;
	
	//邮箱
	private String mail;
	
	//电话号码
	private String phone;
	
	//地址
	private String address;
	
	//创建人
	private String createBy;
	
	//创建时间
	private String createTime;
	
	//更新时间
	private String updateTime;

	
	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getClassAndGrade() {
		return classAndGrade;
	}

	public void setClassAndGrade(String classAndGrade) {
		this.classAndGrade = classAndGrade;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}