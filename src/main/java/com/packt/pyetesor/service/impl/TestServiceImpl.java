package com.packt.pyetesor.service.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import com.packt.pyetesor.domain.Postim;
import com.packt.pyetesor.domain.Rezultat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.packt.pyetesor.database.Database;
import com.packt.pyetesor.domain.Question;
import com.packt.pyetesor.domain.Test;
import com.packt.pyetesor.dto.TestDTO;
import com.packt.pyetesor.service.TestService;

@Service
public class TestServiceImpl implements TestService {
	@Autowired
	private Database databaz;
	
	public int addTest(String testName,int categoryName,int userId){
		Connection c = null;
		int tId=0;
		ArrayList<String> array = new ArrayList<String>();
		try {
			LocalDate date = LocalDate.now(); 
			c = databaz.estamblishConnection();
			String sql1 = "SELECT * FROM tests WHERE testName = '" + testName + "'";
			PreparedStatement pstmt1 = c.prepareStatement(sql1);
			ResultSet result = pstmt1.executeQuery();
			while (result.next()) {
				array.add(result.getString("testName"));
			}
			if (array.size() == 1) { // ekziston , esht gjetur nje
				return 0;
			}
			else {
				String sql2 = "INSERT INTO tests(testName,seminarId_FK,dateCreated,userId_FK) VALUES('"+testName+"','"+categoryName+"','"+date+"','"+userId+"')";
				PreparedStatement pstmt2 = c.prepareStatement(sql2);
				pstmt2.executeUpdate();

			}
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}

		try {
			String sql1 = "SELECT * FROM tests WHERE testName = '" +testName + "'";
			PreparedStatement pstmt1 = c.prepareStatement(sql1);
			ResultSet result = pstmt1.executeQuery();
			while (result.next()) {
				tId = result.getInt("testId");
			}

			int lloji = 1;
			LocalDate date = LocalDate.now();
			String testid = Integer.toString(tId);
			String sql3 = "INSERT INTO postim(postim, dateCreated, seminarId_FK, lloji) VALUES ('"+testid+"', '"+date+"', '"+categoryName+"', '"+lloji+"')";
			PreparedStatement pstmt3 = c.prepareStatement(sql3);
			pstmt3.executeUpdate();
			databaz.closeConnection(c);
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
		return tId;
	}
	public void addQuestionAndTest(String a, int testId){
		Connection c = null;		
		try {
			ObjectMapper mapper = new ObjectMapper();
			Question obj = mapper.readValue(a, Question.class);
			//System.out.println(obj.getQuestion());//sepse me duhet vtm id dhe vtm id kam kaluar 
			c = databaz.estamblishConnection();
			String[]tokens = obj.getQuestion().split(" ");
			for(int i=0;i<tokens.length;i++){
				//System.out.println(tokens[i]);
				String sql1="INSERT INTO createtests(testId_FK , questionId_FK) VALUES('"+testId+"','"+tokens[i]+"')" ;// 
				PreparedStatement pstmt1 = c.prepareStatement(sql1);
				pstmt1.executeUpdate();
			}
			databaz.closeConnection(c);
		} 
		catch (Exception e) {
			System.out.println(e);
		}
	}
	public ArrayList<TestDTO> listAllTests(int idUseri){
		Connection c = null;
		ArrayList<Test> testet = new ArrayList<Test>();
		ArrayList<Question> questions ;
		ArrayList<Integer> array ;
		ArrayList<TestDTO> testDto = new ArrayList<TestDTO>();
		
		try {
			c = databaz.estamblishConnection();
			String sql1="SELECT * FROM tests WHERE userId_FK ='"+idUseri+"'" ;
			PreparedStatement pstmt1 = c.prepareStatement(sql1);
			ResultSet result1 = pstmt1.executeQuery();
			while (result1.next()){
				testet.add(new Test(result1.getInt("testId"),result1.getString("testName"),result1.getDate("dateCreated"),result1.getInt("seminarId_FK")));
			}
			for(Test test : testet) {
				array = new ArrayList<Integer>();
				String sql2="SELECT * FROM createtests WHERE testId_FK ='"+test.getTestId()+"'" ;
			    PreparedStatement pstmt2 = c.prepareStatement(sql2);
			    ResultSet result2 = pstmt2.executeQuery();
			    while(result2.next()){
			    	array.add(result2.getInt("questionId_FK"));
			    }
			    questions = new ArrayList<Question>();
			    for(int i=0;i<array.size();i++) {
			    	String sql3="SELECT * FROM questions WHERE questionId ='"+array.get(i)+"'" ;
				    PreparedStatement pstmt3 = c.prepareStatement(sql3);
				    ResultSet result3 = pstmt3.executeQuery();
				    while(result3.next()){
				    	questions.add(new Question(result3.getInt("questionId"),result3.getString("question"),result3.getInt("type")));
				    }     
			    }
			    testDto.add(new TestDTO(new Test(test.getTestId(),test.getTestName(),test.getDateCreated(),test.getCategoryName()),questions ));  
			}
			
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		databaz.closeConnection(c);
		return testDto;
	}
	public String deleteTest(String a){
		Connection c = null;		
		try {
			ObjectMapper mapper = new ObjectMapper();//fhijm dhe rezultatin , nqs nuk dim si kanqen pyetjet na rroft vleresimi , duhet t ditur pyetjet dhe per t par vleresimin , pra duke ditur pyetjejt dim veshtirsin e testit e si ka dal 
			Test obj = mapper.readValue(a, Test.class);
			c = databaz.estamblishConnection();
			String sql1="DELETE FROM createtests WHERE testId_FK ='"+obj.getTestId()+"'" ;
			PreparedStatement pstmt1 = c.prepareStatement(sql1);
			pstmt1.executeUpdate();
			String sql2="DELETE FROM results WHERE testId_FK='"+obj.getTestId()+"'" ;
			PreparedStatement pstmt2 = c.prepareStatement(sql2);
			pstmt2.executeUpdate();
			String sql3="DELETE FROM tests WHERE testId ='"+obj.getTestId()+"'" ;
			PreparedStatement pstmt3 = c.prepareStatement(sql3);
			pstmt3.executeUpdate();
			databaz.closeConnection(c);
			return "ok";//nqs cdo gje ka shkuar ok 	
			
		} 
		catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	
	
	
	public Test findTest(int testID){
		Connection c = null;
		Test t =null;
		try {
			c = databaz.estamblishConnection();
			String sql1="SELECT * FROM tests WHERE testId='"+testID+"'" ;// id e cdo pyetjeje esht unike kshuqe dihet qe do kthej vtm nje rezult , prandja po e mar te mireqen dhe spo bej cikel
			PreparedStatement pstmt1 = c.prepareStatement(sql1);
			ResultSet result1 = pstmt1.executeQuery();
			while (result1.next()){
				t= new Test(result1.getInt("testId"),result1.getString("testName"),result1.getDate("dateCreated"),result1.getInt("seminarId_FK"));
			}
			//System.out.println(result1.getInt("questionId"));
		}
		catch(Exception e){	
			return null;
		}
		return t;
	}
	public String updateTest(Test t){
		Connection c = null;
		try {
			c = databaz.estamblishConnection();
			String sql1="UPDATE tests SET testName='"+ t.getTestName()+"',seminarId_FK='"+t.getCategoryName()+"',dateCreated='"+new SimpleDateFormat("yyyy-MM-dd").format(t.getDateCreated())+"' WHERE testId='"+t.getTestId()+"'" ;
			PreparedStatement pstmt1 = c.prepareStatement(sql1);
			pstmt1.executeUpdate();
			databaz.closeConnection(c);
			//System.out.println(t.getDateCreated());
			return "testi u uptejtua me sukses";
		}
		catch(Exception e){
			return e+"nje gabim ndondhi , provojeni perseri";
		}	
	}
	
	
	public ArrayList<Test> showTestByCriteria(String a){
		Connection c = null;
		//Test t =null;
		String sql1 = "";
		ArrayList<Test> testet = new ArrayList<Test>();
		try {
			ObjectMapper mapper = new ObjectMapper();//fhijm dhe rezultatin , nqs nuk dim si kanqen pyetjet na rroft vleresimi , duhet t ditur pyetjet dhe per t par vleresimin , pra duke ditur pyetjejt dim veshtirsin e testit e si ka dal 
			Test obj = mapper.readValue(a, Test.class);
			c = databaz.estamblishConnection();
			System.out.println(obj.getTestName());
			if(obj.getCategoryName()!=0){
				sql1="SELECT * FROM tests WHERE seminarId_FK='"+obj.getCategoryName()+"'" ;
			}
			if(obj.getTestName()!=null){
				sql1="SELECT * FROM tests WHERE testName='"+obj.getTestName()+"'" ;
			}
			System.out.println(sql1);
			PreparedStatement pstmt1 = c.prepareStatement(sql1);
			ResultSet result1 = pstmt1.executeQuery();
			while (result1.next()){
				testet.add(new Test(result1.getInt("testId"),result1.getString("testName"),result1.getDate("dateCreated"),result1.getInt("seminarId_FK")));
			}
		}
		catch(Exception e){	
			return null;
		}
		return testet;
	}


	/*public ArrayList<Test> showTestsPerCategory(int categoryId){
		Connection c = null;
		ArrayList<Test> t = new ArrayList<>();
		try {
			c = databaz.estamblishConnection();
			String sql1="SELECT * FROM categories, tests WHERE categories.categoryId='"+categoryId+"' AND categories.categoryName = tests.categoryName" ;// id e cdo pyetjeje esht unike kshuqe dihet qe do kthej vtm nje rezult , prandja po e mar te mireqen dhe spo bej cikel
			PreparedStatement pstmt1 = c.prepareStatement(sql1);
			ResultSet result1 = pstmt1.executeQuery();
			while (result1.next()){
				t.add(new Test(result1.getInt("testId"),result1.getString("testName"),result1.getDate("dateCreated"),result1.getString("categoryName")));
			}
			//System.out.println(result1.getInt("questionId"));
		}
		catch(Exception e){
			return null;
		}
		return t;
	}

	 */
	
	
	
	//duhet bere qe dhe kur fshihet pyetj e fundit nga tesit , i gjith testi t fshihet automatikisht , me te par me te ber , se mase useri do t fshij pyetje dhe ti populloj perseri , varet kjo gje .
	//krijimi i pyetsorit nga ana e klientit 
	
	
	
	public ArrayList<Test> showAllTestPerUser(int userId){
		Connection c = null;
		ArrayList<Test> testet = new ArrayList<Test>();
		try {
			c = databaz.estamblishConnection();
			String sql1="SELECT * FROM results WHERE userId_FK='"+userId+"'" ;
			PreparedStatement pstmt1 = c.prepareStatement(sql1);
			ResultSet result1 = pstmt1.executeQuery();
			while (result1.next()){
				String sql2="SELECT * FROM tests WHERE testId='"+result1.getInt("testId_FK")+"'" ;
				PreparedStatement pstmt2 = c.prepareStatement(sql2);
				ResultSet result2 = pstmt2.executeQuery();
				while (result2.next()){
					testet.add(new Test(result2.getInt("testId"),result2.getString("testName"),result2.getDate("dateCreated"),result2.getInt("seminarId_FK"),result1.getInt("result")));
				}
			}
		}
		catch(Exception e){	
			System.out.println(e);
		}
		return testet;
	}


	public ArrayList<Test> showAllTests(){
		Connection c = null;
		ArrayList<Test> testet = new ArrayList<Test>();
		try {
			c = databaz.estamblishConnection();
			String sql1="SELECT * FROM tests ORDER BY dateCreated DESC" ;// id e cdo pyetjeje esht unike kshuqe dihet qe do kthej vtm nje rezult , prandja po e mar te mireqen dhe spo bej cikel
			PreparedStatement pstmt1 = c.prepareStatement(sql1);
			ResultSet result1 = pstmt1.executeQuery();
			while (result1.next()){
				testet.add(new Test(result1.getInt("testId"),result1.getString("testName"),result1.getDate("dateCreated"),result1.getInt("seminarId_FK")));
			}
			//System.out.println(result1.getInt("questionId"));
		}
		catch(Exception e){
			return null;
		}
		return testet;
	}


	public ArrayList<Test> showAllTestsPedagog(int userId){
		Connection c = null;
		ArrayList<Test> testet = new ArrayList<Test>();
		try {
			c = databaz.estamblishConnection();
			String sql1="SELECT * FROM tests WHERE userId_FK='"+userId+"' ORDER BY dateCreated DESC" ;// id e cdo pyetjeje esht unike kshuqe dihet qe do kthej vtm nje rezult , prandja po e mar te mireqen dhe spo bej cikel
			PreparedStatement pstmt1 = c.prepareStatement(sql1);
			ResultSet result1 = pstmt1.executeQuery();
			while (result1.next()){
				testet.add(new Test(result1.getInt("testId"),result1.getString("testName"),result1.getDate("dateCreated"),result1.getInt("seminarId_FK")));
			}
			//System.out.println(result1.getInt("questionId"));
		}
		catch(Exception e){
			return null;
		}
		return testet;
	}



	public ArrayList<Test> testeteMia(int userId){
		Connection c = null;
		ArrayList<Test> testet = new ArrayList<Test>();
		try {
			c = databaz.estamblishConnection();
			String sql1 = "SELECT * FROM seminar, tests, userseminar WHERE userseminar.userId_FK ='"+userId+"' AND tests.seminarId_FK=userseminar.seminarId_FK AND seminar.seminarId=tests.seminarId_FK ORDER BY tests.dateCreated DESC";
			PreparedStatement pstmt1 = c.prepareStatement(sql1);
			ResultSet result2 = pstmt1.executeQuery();

			while (result2.next()) {// per efekt kohe po e mar t mirqen qe esht vtm 1 pyetje me ate id pasi id esht unike , autoincrement
                /*sql1 = "SELECT * FROM postim WHERE seminarId_FK='"+result.getInt("seminarId_FK")+"' ORDER BY dateCreated DESC";
                pstmt1 = c.prepareStatement(sql1);
                ResultSet result2 = pstmt1.executeQuery();
                System.out.println("Para next-it");
                while (result2.next()) */
				testet.add(new Test(result2.getInt("testId"),result2.getString("testName"),result2.getDate("dateCreated"),result2.getInt("seminarId_FK")));
				System.out.println("Tani pas next-it");
			}
		} catch (Exception e) {
			System.out.println("Nje gabim ka ndodhur valle?");
			e.printStackTrace();
			return null;
		}
		try {
			databaz.closeConnection(c);
		} catch (Exception e) {
			System.out.println("Gabim ne mbylljen e db");
			return null;
		}
		return testet;
	}

	public ArrayList<Test> testetKurs(int seminarId){
		Connection c = null;
		ArrayList<Test> testet = new ArrayList<Test>();
		try {
			c = databaz.estamblishConnection();
			String sql1 = "SELECT * FROM tests WHERE seminarId_FK='"+seminarId+"' ORDER BY dateCreated DESC";
			PreparedStatement pstmt1 = c.prepareStatement(sql1);
			ResultSet result2 = pstmt1.executeQuery();

			while (result2.next()) {// per efekt kohe po e mar t mirqen qe esht vtm 1 pyetje me ate id pasi id esht unike , autoincrement
                /*sql1 = "SELECT * FROM postim WHERE seminarId_FK='"+result.getInt("seminarId_FK")+"' ORDER BY dateCreated DESC";
                pstmt1 = c.prepareStatement(sql1);
                ResultSet result2 = pstmt1.executeQuery();
                System.out.println("Para next-it");
                while (result2.next()) */
				testet.add(new Test(result2.getInt("testId"),result2.getString("testName"),result2.getDate("dateCreated"),result2.getInt("seminarId_FK")));
				System.out.println("Tani pas next-it");
			}
		} catch (Exception e) {
			System.out.println("Nje gabim ka ndodhur valle?");
			e.printStackTrace();
			return null;
		}
		try {
			databaz.closeConnection(c);
		} catch (Exception e) {
			System.out.println("Gabim ne mbylljen e db");
			return null;
		}
		return testet;
	}


	public ArrayList<Rezultat> rezultatet(int testId){
		Connection c = null;
		ArrayList<Rezultat> testet = new ArrayList<Rezultat>();
		try {
			c = databaz.estamblishConnection();
			String sql1 = "SELECT * FROM tests, users, results, seminar WHERE testId='"+testId+"' AND results.testId_FK='"+testId+"' AND results.userId_FK=userId AND tests.seminarId_FK=seminarId";
			PreparedStatement pstmt1 = c.prepareStatement(sql1);
			ResultSet result2 = pstmt1.executeQuery();

			while (result2.next()) {// per efekt kohe po e mar t mirqen qe esht vtm 1 pyetje me ate id pasi id esht unike , autoincrement
                /*sql1 = "SELECT * FROM postim WHERE seminarId_FK='"+result.getInt("seminarId_FK")+"' ORDER BY dateCreated DESC";
                pstmt1 = c.prepareStatement(sql1);
                ResultSet result2 = pstmt1.executeQuery();
                System.out.println("Para next-it");
                while (result2.next()) */
				testet.add(new Rezultat(result2.getString("firstName"), result2.getString("lastName"), result2.getString("seminar"), result2.getInt("result"), result2.getDate("dateCreated")));
				System.out.println("Tani pas next-it");
			}
		} catch (Exception e) {
			System.out.println("Nje gabim ka ndodhur valle?");
			e.printStackTrace();
			return null;
		}
		try {
			databaz.closeConnection(c);
		} catch (Exception e) {
			System.out.println("Gabim ne mbylljen e db");
			return null;
		}
		return testet;
	}







}