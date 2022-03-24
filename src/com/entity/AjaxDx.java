package com.entity;


public class AjaxDx {
	
    
	@Override
	public String toString() {
		return "AjaxChat [name=" + name + ", value=" + value + "]";
	}
	

	private String value;
	
	private String name;
	

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


}
