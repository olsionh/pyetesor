package com.packt.pyetesor.controller;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.packt.pyetesor.domain.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.packt.pyetesor.domain.User;
import com.packt.pyetesor.service.UserService;

@Controller
@RequestMapping(value = "/user")
@SessionAttributes({"loguar"})
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/test/bejTest" , method =RequestMethod.GET)
	public String doTest (Model model, @ModelAttribute("loguar") User userLoguar) {
		return "bejTest";
	}

	@RequestMapping(value = "/save/result" , method =RequestMethod.POST)
	public void saveResult(Model model,HttpServletRequest request,@ModelAttribute("loguar") User userLoguar) {
		String a = "";
		Map<String, String[]> map = request.getParameterMap();
		for(String paramName:map.keySet()) {
            String[] paramValues = map.get(paramName);
            a=paramName;
        }
		 userService.saveResult(a,userLoguar.getUserId());
	}
	

}