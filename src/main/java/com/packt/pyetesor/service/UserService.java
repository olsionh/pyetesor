package com.packt.pyetesor.service;

import com.packt.pyetesor.domain.User;

import java.util.ArrayList;

public interface UserService {
	
	public void saveResult(String a,int userId);
	public boolean eshteDheneProvimi(int userId, int testId);
	public ArrayList<User> showUsersPerSeminar(int seminarId);
	public ArrayList<User> listoPerdoruesit();
	public void ndryshoPasswordPedagog(String newpassword, int userId);
	public boolean loginPerHereTePare(int userId);

}
