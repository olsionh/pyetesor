package com.packt.pyetesor.service;


import com.packt.pyetesor.domain.User;

public interface RegisterService {

	public String addUser(User newUser);
	public String shtoPedagog(User newUser);

}
