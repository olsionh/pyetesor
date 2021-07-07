package com.packt.pyetesor.service;
import java.util.ArrayList;
import com.packt.pyetesor.domain.Question;

public interface QuestionService {

	public int addQuestion(Question q , int userid);
	public Question showQuestion(int qId);
	public ArrayList<Question> showAllQuestion(int userId);
	public Question findQuestion(int questionID);
	public String updateQuestion(Question q);
	public String deleteQuestionFromTest(String a);
	public String deleteQuestionFromDatabase(String a);
	
}