package com.entity;

public class Bulletin {
	

	@Override
	public String toString() {
		return "Bulletin [content=" + content + ", createTime=" + createTime
				+ ", id=" + id + ", isCheck=" + isCheck + ", topic=" + topic
				+ "]";
	}

	//�����id
	private int id;
	
	//�������Ŀ
	private String topic;
	
	//���������
	private String content;
	
	private String isCheck;
	
	//����ʱ��
	private String createTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getIsCheck() {
		return isCheck;
	}

	public void setIsCheck(String isCheck) {
		this.isCheck = isCheck;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	
}
