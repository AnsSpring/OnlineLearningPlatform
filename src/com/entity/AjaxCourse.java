package com.entity;

/**
 * 学生选课情况
 * @author Administrator
 *
 */
public class AjaxCourse {
	

	@Override
	public String toString() {
		return "CourseResult [n=" + n + ", name=" + name + ", value=" + value
				+ "]";
	}

	private String value;
	
	private String name;
	
	private Double n;

	

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getN() {
		return n;
	}

	public void setN(Double n) {
		this.n = n;
	}

}
