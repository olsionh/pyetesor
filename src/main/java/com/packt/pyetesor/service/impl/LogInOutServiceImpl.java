package com.packt.pyetesor.service.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.packt.pyetesor.database.Database;
import com.packt.pyetesor.domain.User;
import com.packt.pyetesor.service.LogInOutService;
@Service
public class LogInOutServiceImpl implements LogInOutService{
	@Autowired
	private Database databaz;
	
	public User exists(User user){
		Connection c = null;
		User perdorues = null;
		ArrayList<String> array = new ArrayList<String>();
		try {
			c = databaz.estamblishConnection();
			String sql="SELECT * FROM users WHERE username = '"+user.getUsername()+"' AND password ='"+user.getPassword()+"'" ;
			PreparedStatement pstmt = c.prepareStatement(sql);
			ResultSet result = pstmt.executeQuery();
			while (result.next()){
				array.add(result.getString("username"));
				perdorues = new User(result.getInt("userId"),result.getString("firstName"),result.getString("lastName"),result.getString("username"),result.getString("password"),result.getString("email"), result.getString("role"));
			}
			
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		databaz.closeConnection(c);
		if(array.size()==1){
			return perdorues;
		}
		else
			return null;
		
	}
}
