package com.entity;

public class Person {
	
	//会员ID
	private int id;
	
	//物品ID
	private int gid;
	
	//申请标识
	private String flag;
	
	//会员姓名
	private String username;
	
	//会员电话号码
	private String number;
	
	//会员地址
	private String address;
	
	//物品名字
	private String name;
	
	//物品价格
	private String price;
	
	//会员拿去交换的物品名字
	private String mygood;
	
	//买家需要删除的物品ID
	private int did;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getMygood() {
		return mygood;
	}

	public void setMygood(String mygood) {
		this.mygood = mygood;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}


}
