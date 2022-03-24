package com.entity;

/***
 * 单选题型
 * @author Administrator
 *
 */
public class SingleChoice {
	
    
	
	@Override
	public String toString() {
		return "SingleChoice [answer=" + answer + ", createTime=" + createTime
				+ ", four=" + four + ", id=" + id + ", name=" + name + ", one="
				+ one + ", pcode=" + pcode + ", question=" + question
				+ ", score=" + score + ", three=" + three + ", two=" + two
				+ "]";
	}

	private int id;
	
	private String pcode;
	
	private String question;

	private String one;
	
	private String two;
	
	private String three;
	
	private String four;
	
	private String answer;
	
	private int score;
	
	private String createTime;
	
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
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

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getOne() {
		return one;
	}

	public void setOne(String one) {
		this.one = one;
	}

	public String getTwo() {
		return two;
	}

	public void setTwo(String two) {
		this.two = two;
	}

	public String getThree() {
		return three;
	}

	public void setThree(String three) {
		this.three = three;
	}

	public String getFour() {
		return four;
	}

	public void setFour(String four) {
		this.four = four;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
