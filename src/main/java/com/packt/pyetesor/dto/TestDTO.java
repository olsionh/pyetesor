package com.packt.pyetesor.dto;

import java.util.ArrayList;

import com.packt.pyetesor.domain.Alternativ;
import com.packt.pyetesor.domain.Question;
import com.packt.pyetesor.domain.Seminar;
import com.packt.pyetesor.domain.Test;

public class TestDTO {

	public Test testi;
	public ArrayList<Question> questions;
	public ArrayList<Alternativ> alternativs;
	
	public void setTesti(Test testi){
		this.testi=testi;
	}


    public Test getTesti(){
		return testi;
	}
	public void setQuestions(ArrayList<Question> questions){
		this.questions=questions;
	}
	public ArrayList<Question> getQuestions(){
		return questions;
	}
	public void setAlternativs(ArrayList<Alternativ> alternativs){
		this.alternativs=alternativs;
	}
	public ArrayList<Alternativ> getAlternativs(){
		return alternativs;
	}
	
	public TestDTO(){
		super();
	}
	public TestDTO(Test testi,ArrayList<Question> questions){
		this.testi=testi;
		this.questions=questions;

	}
	public TestDTO(ArrayList<Question> questions,ArrayList<Alternativ> alternativs){
		this.questions=questions;
		this.alternativs=alternativs;

	}
}
