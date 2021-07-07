package com.packt.pyetesor.service.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.packt.pyetesor.database.Database;
import com.packt.pyetesor.domain.User;
import com.packt.pyetesor.service.RegisterService;
@Service
public class RegisterServiceImpl implements RegisterService {
	@Autowired
	private Database databaz;

	public String addUser(User newUser) {
		Connection c = null;
		ArrayList<String> array = new ArrayList<String>();
		try {
			c = databaz.estamblishConnection();
			String sql1 = "SELECT * FROM users WHERE username = '" + newUser.getUsername() + "' OR email = '"+newUser.getEmail()+"'";
			PreparedStatement pstmt1 = c.prepareStatement(sql1);
			ResultSet result = pstmt1.executeQuery();
			while (result.next()) {
				array.add(result.getString("username"));
			}

			if (array.size() == 1) {
				return "ky username ekziston ";
			}
			else {
				String sql2 = "INSERT INTO users(firstName,lastName,username,email,password, role) VALUES('"+newUser.getFirstName() +"','"+newUser.getLastName() +"','" + newUser.getUsername() + "','"
						+ newUser.getEmail() + "','" + newUser.getPassword() + "','user')";
				PreparedStatement pstmt2 = c.prepareStatement(sql2);
				pstmt2.executeUpdate();
			}
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		try {
			System.out.println("te dhenat u hodhen");
			databaz.closeConnection(c);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		return newUser.getUsername()+" ju u regjistruat me sukses";
	}


	public String shtoPedagog(User newUser) {
		Connection c = null;
		ArrayList<String> array = new ArrayList<String>();
		try {
			c = databaz.estamblishConnection();
			int flag = 0;
			String sql1 = "SELECT * FROM users WHERE username = '" + newUser.getUsername() + "' OR email = '"+newUser.getEmail()+"'";
			PreparedStatement pstmt1 = c.prepareStatement(sql1);
			ResultSet result = pstmt1.executeQuery();
			while (result.next()) {
				array.add(result.getString("username"));
			}

			if (array.size() == 1) {
				return "Ky username ekziston ";
			}
			else {
				String sql2 = "INSERT INTO users(firstName,lastName,username,email,password, role, flag) VALUES('"+newUser.getFirstName() +"','"+newUser.getLastName() +"','" + newUser.getUsername() + "','"
						+ newUser.getEmail() + "','" + newUser.getPassword() + "','pedagog', '"+flag+"')";
				PreparedStatement pstmt2 = c.prepareStatement(sql2);
				pstmt2.executeUpdate();
			}
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		try {
			System.out.println("te dhenat u hodhen");
			databaz.closeConnection(c);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		return newUser.getUsername()+" ju u regjistruat me sukses";
	}
}
