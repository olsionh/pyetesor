package com.packt.pyetesor.domain;
import java.io.Serializable;
public class Question implements Serializable {
	private static final long serialVersionUID = 3678107792576131001L;
	
	private int questionId;
	private String question;
	private int type;
	private int testId_FK;
	
	
	public void setTestId_FK(int testId_FK) {
		this.testId_FK = testId_FK;
	}
	public int getTestId_FK() {
		return testId_FK;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getType() {
		return type;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getQuestion() {
		return question;
	}
	
	public Question() {
		super();
	}
	public Question(int questionId,String question,int type) {
		this.questionId=questionId;
		this.question = question;
		this.type=type;

	}
	
	
	
	
}
