package com.entity;

public class ChatTotal {
	
	
	
	@Override
	public String toString() {
		return "ChatTotal [code=" + code + ", id=" + id + ", name=" + name
				+ ", total=" + total + "]";
	}

	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private String total;
	
	private String code;
	
	private String name;

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
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

}
