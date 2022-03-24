package com.entity;

public class Result {
	
	
	@Override
	public String toString() {
		return "Result [code=" + code + ", createTime=" + createTime + ", id="
				+ id + ", name=" + name + ", realName=" + realName + ", score="
				+ score + ", totalScore=" + totalScore + ", type=" + type
				+ ", typeValue=" + typeValue + ", usercode=" + usercode + "]";
	}

	private Integer id;
	
	private String type;
	
	private String typeValue;
	
	private String code;
	
	private String name;
	
	private String usercode;
	
	private String realName;
	
	private Integer totalScore;
	
	private Integer score;
	
	private String createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTypeValue() {
		return typeValue;
	}

	public void setTypeValue(String typeValue) {
		this.typeValue = typeValue;
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

	public Integer getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	
}
