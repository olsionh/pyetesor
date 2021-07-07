package com.packt.pyetesor.service;
import java.util.ArrayList;

import com.packt.pyetesor.domain.Rezultat;
import com.packt.pyetesor.domain.Test;
import com.packt.pyetesor.dto.TestDTO;

public interface TestService {

	public int addTest(String testName, int categoryName, int userId);

	public void addQuestionAndTest(String a, int testId);

	public ArrayList<TestDTO> listAllTests(int idUseri);

	public String deleteTest(String a);

	public Test findTest(int testID);

	public String updateTest(Test t);

	public ArrayList<Test> showTestByCriteria(String a);

	public ArrayList<Test> showAllTestPerUser(int userId);

	//public ArrayList<Test> showTestsPerCategory(int categoryId);
	public ArrayList<Test> showAllTests();

	public ArrayList<Test> testeteMia(int userId);

	public ArrayList<Test> testetKurs(int seminarId);

	public ArrayList<Test> showAllTestsPedagog(int userId);

	public ArrayList<Rezultat> rezultatet(int testId);

}
