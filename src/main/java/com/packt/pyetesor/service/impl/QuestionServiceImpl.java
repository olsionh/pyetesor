package com.packt.pyetesor.service.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.packt.pyetesor.database.Database;
import com.packt.pyetesor.domain.Question;
import com.packt.pyetesor.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	private Database databaz;
	
	public int addQuestion(Question q,int userId){
		Connection c = null;
		int qId=0;
		ArrayList<String> array = new ArrayList<String>();
		try {
			c = databaz.estamblishConnection();
			String sql1 = "SELECT * FROM questions WHERE question = '" + q.getQuestion() + "' AND userId_FK ='"+userId+"'";
			PreparedStatement pstmt1 = c.prepareStatement(sql1);
			ResultSet result = pstmt1.executeQuery();
			while (result.next()) {
				array.add(result.getString("question"));
			}

			if (array.size() == 1) {
				return 0;
			}
			else {
				String sql2 = "INSERT INTO questions(question,type,userId_FK) VALUES('"+q.getQuestion()+"','"+q.getType()+"','" + userId + "')";
				PreparedStatement pstmt2 = c.prepareStatement(sql2);
				pstmt2.executeUpdate();
			}
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
		try {
			String sql1 = "SELECT * FROM questions WHERE question = '" + q.getQuestion() + "' AND userId_FK ='"+userId+"'";
			PreparedStatement pstmt1 = c.prepareStatement(sql1);
			ResultSet result = pstmt1.executeQuery();
			while (result.next()) {
				qId = result.getInt("questionId");
			}
			databaz.closeConnection(c);
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
		return qId;
		
	}

	public Question showQuestion(int qId){
		Connection c = null;
		Question q = null;
		try {
			c = databaz.estamblishConnection();
			String sql1 = "SELECT * FROM questions WHERE questionId = '" + qId+ "'";
			PreparedStatement pstmt1 = c.prepareStatement(sql1);
			ResultSet result = pstmt1.executeQuery();
			while (result.next()) {
				q = new Question(result.getInt("questionId"),result.getString("question"),result.getInt("type"));
			}
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		try {	
			databaz.closeConnection(c);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		return q;
	}

	public ArrayList<Question> showAllQuestion(int userId){
		Connection c = null;
		ArrayList<Question> pyetjet = new ArrayList<Question>();
		try {
			c = databaz.estamblishConnection();
			String sql1 = "SELECT * FROM questions WHERE userId_FK = '" + userId+ "'";
			PreparedStatement pstmt1 = c.prepareStatement(sql1);
			ResultSet result = pstmt1.executeQuery();
			while (result.next()) {// per efekt kohe po e mar t mirqen qe esht vtm 1 pyetje me ate id pasi id esht unike , autoincrement 
				pyetjet.add(new Question(result.getInt("questionId"),result.getString("question"),result.getInt("type")));
			}
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		try {	
			databaz.closeConnection(c);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		return pyetjet;
	}

	public Question findQuestion(int questionID){
		Connection c = null;
		Question q =null;
		try {
			c = databaz.estamblishConnection();
			String sql1="SELECT * FROM questions WHERE questionId='"+questionID+"'" ;// id e cdo pyetjeje esht unike kshuqe dihet qe do kthej vtm nje rezult , prandja po e mar te mireqen dhe spo bej cikel
			PreparedStatement pstmt1 = c.prepareStatement(sql1);
			ResultSet result1 = pstmt1.executeQuery();
			while (result1.next()){
				q= new Question(result1.getInt("questionId"),result1.getString("question"),result1.getInt("type"));
			}
		}
		catch(Exception e){	
			return null;
		}
		return q;
	}
	
	public String updateQuestion(Question q){// nje her per nje here tipin po e le pa ndryshuar , nqs do kem koh le t bej
		Connection c = null;
		try {
			c = databaz.estamblishConnection();
			String sql1="UPDATE questions SET question='"+q.getQuestion()+"' WHERE questionId='"+q.getQuestionId()+"'" ;// 
			PreparedStatement pstmt1 = c.prepareStatement(sql1);
			pstmt1.executeUpdate();
			databaz.closeConnection(c);
			return "sukses";
		}
		catch(Exception e){
			return "nje gabim ka ndodhur ";
		}
	}

	public String deleteQuestionFromTest(String a){
		Connection c = null;		
		try {
			ObjectMapper mapper = new ObjectMapper();
			Question obj = mapper.readValue(a, Question.class);
			c = databaz.estamblishConnection();
			String sql2="DELETE FROM createtests WHERE questionId_FK ='"+obj.getQuestionId()+"' AND testId_FK='"+obj.getTestId_FK()+"'" ;
			PreparedStatement pstmt2 = c.prepareStatement(sql2);
			pstmt2.executeUpdate();
			databaz.closeConnection(c);
			return "ok";
		} 
		catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	public String deleteQuestionFromDatabase(String a){
		Connection c = null;		
		try {
			ObjectMapper mapper = new ObjectMapper();
			Question obj = mapper.readValue(a, Question.class);
			c = databaz.estamblishConnection();
			String sql2="DELETE FROM createtests WHERE questionId_FK ='"+obj.getQuestionId()+"'" ;
			PreparedStatement pstmt2 = c.prepareStatement(sql2);
			pstmt2.executeUpdate();
			String sql1="DELETE FROM alternativs WHERE questionId_FK ='"+obj.getQuestionId()+"'" ;
			PreparedStatement pstmt1 = c.prepareStatement(sql1);
			pstmt1.executeUpdate();
			String sql3="DELETE FROM questions WHERE questionId ='"+obj.getQuestionId()+"'" ;
			PreparedStatement pstmt3 = c.prepareStatement(sql3);
			pstmt3.executeUpdate();
			databaz.closeConnection(c);
			return "ok";
		} 
		catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	//------------------------------------------------------------------------
	/*public ArrayList<TestDTO> showQuestionOfTest(String a){
		Connection c = null;
		ArrayList<Integer> array = new ArrayList<Integer>();
		ArrayList<Question> pyetjet = new ArrayList<Question>();
		ArrayList<Alternativ> alternativs;
		ArrayList<TestDTO> testDto = new ArrayList<TestDTO>();
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			Test obj = mapper.readValue(a, Test.class);
			c = databaz.estamblishConnection();
			String sql1 = "SELECT * FROM createtests WHERE testId_FK = '" + obj.getTestId()+ "'";
			PreparedStatement pstmt1 = c.prepareStatement(sql1);
			ResultSet result = pstmt1.executeQuery();
			while(result.next()){
			    	array.add(result.getInt("questionId_FK"));
			}
			for(int i=0;i<array.size();i++) {
				alternativs = new ArrayList<Alternativ>();
			    String sql2="SELECT * FROM questions WHERE questionId ='"+array.get(i)+"'" ;
				PreparedStatement pstmt2 = c.prepareStatement(sql2);
				ResultSet result2 = pstmt2.executeQuery();
				while(result2.next()){
					pyetjet.add(new Question(result2.getInt("questionId"),result2.getString("question"),result2.getInt("type")));
				}   
				String sql3="SELECT * FROM alternativs WHERE questionId_FK ='"+array.get(i)+"'" ;
				PreparedStatement pstmt3 = c.prepareStatement(sql3);
				ResultSet result3 = pstmt3.executeQuery();
				while(result3.next()){
					alternativs.add(new Alternativ(result3.getInt("alternativId"),result3.getString("alternativ"),result3.getInt("esakt")));
				}     
				testDto.add(new TestDTO(pyetjet,alternativs));  
				    
			}
			databaz.closeConnection(c);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		return testDto;
	}*/
}
