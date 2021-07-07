package com.packt.pyetesor.database.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.pyetesor.database.CreateTables;
import com.packt.pyetesor.database.Database;
@Service
public class CreateTablesImpl implements CreateTables{
	@Autowired
	private  Database databaz;
	
	
	public void createUsersTable(){
		Connection c = null;
		PreparedStatement pstmt = null;
		try {
			c = databaz.estamblishConnection();
			String sql = "CREATE TABLE IF NOT EXISTS users(userId int NOT NULL AUTO_INCREMENT PRIMARY KEY,firstName VARCHAR(255),lastName VARCHAR(255),username VARCHAR(255), email VARCHAR(255) , password VARCHAR(255), role VARCHAR(255), flag int)";
			pstmt = c.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("jadhi" + e);
		} 
		try {
			System.out.println("te dhenat u hodhen");
			databaz.closeConnection(c);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void createTestTable(){
		Connection c = null;
		PreparedStatement pstmt1 = null;
		try {
			c = databaz.estamblishConnection();                                                                  
			String sql1 = "CREATE TABLE IF NOT EXISTS tests(testId int NOT NULL AUTO_INCREMENT PRIMARY KEY,testName VARCHAR(255), dateCreated DATE , seminarId_FK int, userId_FK int ,FOREIGN KEY (userId_FK) REFERENCES users(userId), FOREIGN KEY (seminarId_FK) REFERENCES seminar(seminarId))";
			pstmt1 = c.prepareStatement(sql1);
			pstmt1.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} 
		try {
			System.out.println("te dhenat u hodhen");
			databaz.closeConnection(c);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void createQuestionTable(){
		Connection c = null;
		PreparedStatement pstmt1 = null;
		try {
			c = databaz.estamblishConnection();                                                                  
			String sql1 = "CREATE TABLE IF NOT EXISTS questions(questionId int NOT NULL AUTO_INCREMENT PRIMARY KEY,question VARCHAR(255),type int ,userId_FK int ,FOREIGN KEY (userId_FK) REFERENCES users(userId))";                                                                    
			pstmt1 = c.prepareStatement(sql1);
			pstmt1.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} 
		try {
			System.out.println("te dhenat u hodhen");
			databaz.closeConnection(c);
		} catch (Exception e) {
			System.out.println(e);
		}	
	}
	public void createCategoryTable(){
		Connection c = null;
		PreparedStatement pstmt1 = null;
		try {
			c = databaz.estamblishConnection();                                                                  
			String sql1 = "CREATE TABLE IF NOT EXISTS categories(categoryId int NOT NULL AUTO_INCREMENT PRIMARY KEY,categoryName VARCHAR(255))";                                                                    
			pstmt1 = c.prepareStatement(sql1);
			pstmt1.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} 
		try {
			System.out.println("te dhenat u hodhen");
			databaz.closeConnection(c);
		} catch (Exception e) {
			System.out.println(e);
		}	
	}
	public void createAlternativeTable(){
		Connection c = null;
		PreparedStatement pstmt1 = null;
		try {
			c = databaz.estamblishConnection();                                                                  
			String sql1 = "CREATE TABLE IF NOT EXISTS alternativs(alternativId int NOT NULL AUTO_INCREMENT PRIMARY KEY,alternativ VARCHAR(255),esakt int,questionId_FK int ,FOREIGN KEY (questionId_FK) REFERENCES questions(questionId))";                                                                    
			pstmt1 = c.prepareStatement(sql1);
			pstmt1.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} 
		try {
			System.out.println("te dhenat u hodhen");
			databaz.closeConnection(c);
		} catch (Exception e) {
			System.out.println(e);
		}	
	}
	public void createCreateTestTable(){
		Connection c = null;
		PreparedStatement pstmt1 = null;
		try {
			c = databaz.estamblishConnection();                                                                  
			String sql1 = "CREATE TABLE IF NOT EXISTS createTests(testId_FK int , questionId_FK int ,  PRIMARY KEY(testId_FK,questionId_FK),FOREIGN KEY (testId_FK) REFERENCES tests(testId),FOREIGN KEY (questionId_FK) REFERENCES questions(questionId))";                                                                    
			pstmt1 = c.prepareStatement(sql1);
			pstmt1.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} 
		try {
			System.out.println("te dhenat u hodhen");
			databaz.closeConnection(c);
		} catch (Exception e) {
			System.out.println(e);
		}	
	}
	public void createResultTable(){
		Connection c = null;
		PreparedStatement pstmt1 = null;
		try {
			c = databaz.estamblishConnection();                                                                  
			String sql1 = "CREATE TABLE IF NOT EXISTS results(resultId int NOT NULL AUTO_INCREMENT PRIMARY KEY, result int, testId_FK int , userId_FK int ,FOREIGN KEY (testId_FK) REFERENCES tests(testId),FOREIGN KEY (userId_FK) REFERENCES users(userId))";                                                                    
			pstmt1 = c.prepareStatement(sql1);
			pstmt1.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} 
		try {
			System.out.println("te dhenat u hodhen");
			databaz.closeConnection(c);
		} catch (Exception e) {
			System.out.println(e);
		}	
	}

	public void createSeminarTable(){
		Connection c = null;
		PreparedStatement pstmt = null;
		try {
			c = databaz.estamblishConnection();
			String sql = "CREATE TABLE IF NOT EXISTS seminar(seminarId int NOT NULL AUTO_INCREMENT PRIMARY KEY,seminar VARCHAR(255),pedagogu VARCHAR(255), sesioni VARCHAR(255))";
			pstmt = c.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("jadhi" + e);
		}
		try {
			System.out.println("te dhenat u hodhen");
			databaz.closeConnection(c);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void createPostimTable(){
		Connection c = null;
		PreparedStatement pstmt1 = null;
		try {
			c = databaz.estamblishConnection();
			String sql1 = "CREATE TABLE IF NOT EXISTS postim(postimId int NOT NULL AUTO_INCREMENT PRIMARY KEY, postim TEXT , dateCreated DATE, seminarId_FK int, lloji int ,FOREIGN KEY (seminarId_FK) REFERENCES seminar(seminarId))";
			pstmt1 = c.prepareStatement(sql1);
			pstmt1.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			System.out.println("te dhenat u hodhen");
			databaz.closeConnection(c);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void createKomentTable(){
		Connection c = null;
		PreparedStatement pstmt1 = null;
		try {
			c = databaz.estamblishConnection();
			String sql1 = "CREATE TABLE IF NOT EXISTS koment(komentId int NOT NULL AUTO_INCREMENT PRIMARY KEY, koment TEXT, dateCreated DATE, postimId_FK int, userId_FK int, FOREIGN KEY (postimId_FK) REFERENCES postim(postimId), FOREIGN KEY (userId_FK) REFERENCES users(userId))";
			pstmt1 = c.prepareStatement(sql1);
			pstmt1.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			System.out.println("te dhenat u hodhen");
			databaz.closeConnection(c);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void createUserSeminarTable(){
		Connection c = null;
		PreparedStatement pstmt1 = null;
		try {
			c = databaz.estamblishConnection();
			String sql1 = "CREATE TABLE IF NOT EXISTS userSeminar(seminarId_FK int, userId_FK int, PRIMARY KEY(seminarId_FK,userId_FK), FOREIGN KEY (seminarId_FK) REFERENCES seminar(seminarId), FOREIGN KEY (userId_FK) REFERENCES users(userId))";
			pstmt1 = c.prepareStatement(sql1);
			pstmt1.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			System.out.println("te dhenat u hodhen");
			databaz.closeConnection(c);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
