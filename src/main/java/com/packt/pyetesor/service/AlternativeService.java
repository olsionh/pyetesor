package com.packt.pyetesor.service;
import java.util.ArrayList;
import com.packt.pyetesor.domain.Alternativ;

public interface AlternativeService {

	public void addAlternative(String a,int qId); 
	public ArrayList<Alternativ> showAlternatives(int qId);
	public void saveAlternativeSakt(String a , int qId);
	public void saveAlternativeSaktTypePOJO(String a, int qId );
	public ArrayList<Alternativ> showAlternativesPerQuestion(String a);
	public Alternativ showOnly1Alternatives(int altId);
	
	public String updateAlternative(Alternativ alt);
	public String deleteAlternative(String a);
}
