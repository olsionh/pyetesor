package com.packt.pyetesor.service.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.packt.pyetesor.database.Database;
import com.packt.pyetesor.domain.Alternativ;
import com.packt.pyetesor.domain.Question;
import com.packt.pyetesor.service.AlternativeService;

@Service
public class AlternativeServiceImpl implements AlternativeService{
	@Autowired
	private Database databaz;
	
	public ArrayList<Alternativ> showAlternatives(int qId){
		Connection c = null;
		ArrayList<Alternativ> alternativat = new ArrayList<Alternativ>();
		try {
			c = databaz.estamblishConnection();
			String sql1="SELECT * FROM alternativs WHERE questionId_FK ='"+qId+"'" ;
			PreparedStatement pstmt1 = c.prepareStatement(sql1);
			ResultSet result1 = pstmt1.executeQuery();
			while (result1.next()){
				alternativat.add(new Alternativ(result1.getInt("alternativId"),result1.getString("alternativ"),result1.getInt("esakt")));
			}
			databaz.closeConnection(c);
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		return alternativat;
	}
	public void addAlternative(String a,int qId){
		Connection c = null;	// dhe ketu duhet bere nje tabel e ndermjetme questin alternativ 	
		try {
			ObjectMapper mapper = new ObjectMapper();
			Alternativ obj = mapper.readValue(a, Alternativ.class);
			System.out.println(obj.getAlternativ());//sepse me duhet vtm id dhe vtm id kam kaluar 
			c = databaz.estamblishConnection();
			String sql1="INSERT INTO alternativs(alternativ,questionId_FK) VALUES('"+obj.getAlternativ()+"','"+qId+"')" ;
			PreparedStatement pstmt1 = c.prepareStatement(sql1);
			pstmt1.executeUpdate();
			databaz.closeConnection(c);	
		} 
		catch (Exception e) {
			System.out.println(e);
		}
	}
	public void saveAlternativeSakt(String a , int qId){
		Connection c = null;	// dhe ketu duhet bere nje tabel e ndermjetme questin alternativ 	
		try {
			ObjectMapper mapper = new ObjectMapper();
			Alternativ obj = mapper.readValue(a, Alternativ.class);
			c = databaz.estamblishConnection();
			String[]tokens = obj.getEsakta().split("");
			for(int i=0;i<tokens.length;i++){
				System.out.println(tokens[i]);
				String sql1="UPDATE alternativs SET esakt='1' WHERE alternativId='"+tokens[i]+"'" ;// 
				PreparedStatement pstmt1 = c.prepareStatement(sql1);
				pstmt1.executeUpdate();
			}
			databaz.closeConnection(c);	
		} 
		catch (Exception e) {
			System.out.println(e);
		}
	}


	public void saveAlternativeSaktTypePOJO(String a, int qId ){
		Connection c = null;	// dhe ketu duhet bere nje tabel e ndermjetme questin alternativ
		try {
			ObjectMapper mapper = new ObjectMapper();
			Alternativ obj = mapper.readValue(a, Alternativ.class);
			c = databaz.estamblishConnection();
			String sql1="INSERT INTO alternativs(alternativ,esakt,questionId_FK) VALUES('tipi po jo','"+obj.getEsakta()+"','"+qId+"')" ;
			PreparedStatement pstmt1 = c.prepareStatement(sql1);
			pstmt1.executeUpdate();
			databaz.closeConnection(c);	
		} 
		catch (Exception e) {
			System.out.println(e);
		}
	}
	public ArrayList<Alternativ> showAlternativesPerQuestion(String a){
		Connection c = null;
		ArrayList<Alternativ> alternativat = new ArrayList<Alternativ>();
		try {
			ObjectMapper mapper = new ObjectMapper();
			Question obj = mapper.readValue(a, Question.class);
			c = databaz.estamblishConnection();
			String sql1="SELECT * FROM alternativs WHERE questionId_FK ='"+obj.getQuestionId()+"'" ;
			PreparedStatement pstmt1 = c.prepareStatement(sql1);
			ResultSet result1 = pstmt1.executeQuery();
			while (result1.next()){
				alternativat.add(new Alternativ(result1.getInt("alternativId"),result1.getString("alternativ"),result1.getInt("esakt")));
			}
			databaz.closeConnection(c);
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		return alternativat;
	}
	public Alternativ showOnly1Alternatives(int altId){
		Connection c = null;
		Alternativ a = null;
		try {
			c = databaz.estamblishConnection();
			String sql1="SELECT * FROM alternativs WHERE alternativId ='"+altId+"'" ;
			PreparedStatement pstmt1 = c.prepareStatement(sql1);
			ResultSet result1 = pstmt1.executeQuery();
			while (result1.next()){
				a =new Alternativ(result1.getInt("alternativId"),result1.getString("alternativ"),result1.getInt("esakt"));
			}
			databaz.closeConnection(c);
		} 
		catch (Exception e) {
			return null;
		}
		return a;
	}
	public String updateAlternative(Alternativ alt){
		Connection c = null;
		try {
			c = databaz.estamblishConnection();
			String sql1="UPDATE alternativs SET alternativ='"+alt.getAlternativ() +"',esakt='"+alt.getEsakt()+"' WHERE alternativId='"+alt.getAlternativId()+"'" ;// 
			PreparedStatement pstmt1 = c.prepareStatement(sql1);
			pstmt1.executeUpdate();
			databaz.closeConnection(c);
			return "sukses";
		}
		catch(Exception e){
			return "nje gabim ka ndodhur ";
		}
	}

	public String deleteAlternative(String a){
		Connection c = null;		
		try {
			ObjectMapper mapper = new ObjectMapper();
			Alternativ obj = mapper.readValue(a, Alternativ.class);
			c = databaz.estamblishConnection();
			String sql1="DELETE FROM alternativs WHERE alternativId ='"+obj.getAlternativId()+"'" ;
			PreparedStatement pstmt1 = c.prepareStatement(sql1);
			pstmt1.executeUpdate();
			databaz.closeConnection(c);
			return "ok";//nqs cdo gje ka shkuar ok 	
			
		} 
		catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
