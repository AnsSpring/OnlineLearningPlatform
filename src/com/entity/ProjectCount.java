package com.entity;

public class ProjectCount {
	
    

	@Override
	public String toString() {
		return "ProjectCount [code=" + code + ", id=" + id + ", jqCount="
				+ jqCount + ", name=" + name + ", scCount=" + scCount + "]";
	}

	private Integer id;

	private String code;
	
	private String name;
	
	private String scCount;
	
	private String jqCount;
	
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

	public String getScCount() {
		return scCount;
	}

	public void setScCount(String scCount) {
		this.scCount = scCount;
	}

	public String getJqCount() {
		return jqCount;
	}

	public void setJqCount(String jqCount) {
		this.jqCount = jqCount;
	}

}
