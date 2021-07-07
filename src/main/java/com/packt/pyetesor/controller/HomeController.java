package com.packt.pyetesor.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.packt.pyetesor.database.CreateTables;

@Controller
public class HomeController {
	@Autowired
	private CreateTables ct;
	@RequestMapping("/")
	public String welcome(Model model) {
		ct.createUsersTable();
		ct.createQuestionTable();
		ct.createCategoryTable();
		ct.createTestTable();
		ct.createAlternativeTable();
		ct.createCreateTestTable();
		ct.createResultTable();
		ct.createSeminarTable();
		ct.createPostimTable();
		ct.createKomentTable();
		ct.createUserSeminarTable();
		return "redirect:/user/login";
	}
	




}