package com.packt.pyetesor.domain;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class Test implements Serializable {

	private static final long serialVersionUID = 3678107792576131001L;
	private int testId;
	private String testName;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateCreated;
	private int categoryName;
	private int testScore;
	
	public void setTestId(int testId) {
		this.testId = testId;
	}
	public int getTestId() {
		return testId;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public String getTestName() {
		return testName;
	}
	public void setCategoryName( int categoryName) {
		this.categoryName =categoryName;
	}
	public int getCategoryName() {
		return categoryName;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setTestScore(int testScore) {
		this.testScore = testScore;
	}
	public int getTestScore() {
		return testScore;
	}
	
	
	public Test(int testId,String testName,Date dateCreated,int categoryName){
		this.testId = testId;
		this.testName = testName;
		this.dateCreated = dateCreated;
		this.categoryName =categoryName;
	}
	public Test(int testId,String testName,Date dateCreated,int categoryName,int testScore){
		this.testId = testId;
		this.testName = testName;
		this.dateCreated = dateCreated;
		this.categoryName =categoryName;
		this.testScore = testScore;
	}
	public Test(){
		super();
	}
}
