package com.packt.pyetesor.service.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.packt.pyetesor.domain.Seminar;
import com.packt.pyetesor.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.packt.pyetesor.database.Database;
import com.packt.pyetesor.domain.Test;
import com.packt.pyetesor.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private Database databaz;

	public void saveResult(String a, int userId) {
		Connection c = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			Test obj = mapper.readValue(a, Test.class);
			c = databaz.estamblishConnection();
			String sql1 = "INSERT INTO results(result,testId_FK,userId_FK) VALUES('" + obj.getTestScore() + "','" + obj.getTestId() + "','" + userId + "')";//
			PreparedStatement pstmt1 = c.prepareStatement(sql1);
			pstmt1.executeUpdate();
			databaz.closeConnection(c);
			System.out.println("ok");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public ArrayList<User> showUsersPerSeminar(int seminarId) {
		Connection c = null;
		ArrayList<User> user = new ArrayList<User>();
		try {
			c = databaz.estamblishConnection();
			String sql1 = "SELECT * FROM userseminar WHERE seminarId_FK ='" + seminarId + "'";
			PreparedStatement pstmt1 = c.prepareStatement(sql1);
			ResultSet result = pstmt1.executeQuery();

			while (result.next()) {
				sql1 = "SELECT * FROM users WHERE userId='" + result.getInt("userId_FK") + "'";
				pstmt1 = c.prepareStatement(sql1);
				ResultSet result2 = pstmt1.executeQuery();
				result2.next();
				user.add(new User(result2.getInt("userId"), result2.getString("firstName"), result2.getString("lastName"), result2.getString("username"), result2.getString("password"), result2.getString("email"), result2.getString("role")));
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
		return user;
	}

	public boolean eshteDheneProvimi(int userId, int testId) {
		Connection c = null;

		try {
			c = databaz.estamblishConnection();
			String sql1 = "SELECT * FROM results WHERE userId_FK ='" + userId + "' AND testId_FK ='" + testId + "'";
			PreparedStatement pstmt1 = c.prepareStatement(sql1);
			ResultSet result = pstmt1.executeQuery();
			if (result.next())
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;

	}

	public ArrayList<User> listoPerdoruesit()
	{
		Connection c = null;
		ArrayList<User> users = new ArrayList<User>();
		try {
			c = databaz.estamblishConnection();
			String sql1 = "SELECT * FROM users WHERE role='user'";
			PreparedStatement pstmt1 = c.prepareStatement(sql1);
			ResultSet result = pstmt1.executeQuery();

			while (result.next()) {
				users.add(new User(result.getInt("userId"), result.getString("firstName"), result.getString("lastName"), result.getString("username"), result.getString("password"), result.getString("email"), result.getString("role")));
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
		return users;
	}

	public void ndryshoPasswordPedagog(String newpassword, int userId)
	{

		Connection c = null;
		try {
			c = databaz.estamblishConnection();
			String sql1 = "UPDATE users SET password = '"+newpassword+"', flag = 1 WHERE userId = '"+userId+"' ";
			PreparedStatement pstmt1 = c.prepareStatement(sql1);
			pstmt1.executeUpdate();
			databaz.closeConnection(c);
			System.out.println("ok");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public boolean loginPerHereTePare(int userId)
	{
		Connection c = null;

		try {
			c = databaz.estamblishConnection();
			String sql1 = "SELECT flag FROM users WHERE userId = '"+userId+"'";
			PreparedStatement pstmt1 = c.prepareStatement(sql1);
			ResultSet result = pstmt1.executeQuery();

			result.next();

			if (result.getInt("flag") == 0)
				return true;
			else
				return false;

		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			databaz.closeConnection(c);
		} catch (Exception e) {
			System.out.println(e);
		}

		return true;
	}

}
