package com.packt.pyetesor.domain;

public class Category {
	public int categoryId;
	public String categoryName;
	
	public void setCategoryId(int categoryId)
	{
		this.categoryId = categoryId;
	}
	public int getCategoryId(){
		return categoryId;
	}
	
	public void setCategoryName(String categoryName)
	{
		this.categoryName = categoryName;
	}
	public String getCategoryName(){
		return categoryName;
	}
	public Category(){
		super();
	}
	public Category(int categoryId,String categoryName){
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}
}
