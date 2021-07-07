package com.packt.pyetesor.controller;
import java.util.ArrayList;
import java.util.List;

import com.packt.pyetesor.domain.Seminar;
import com.packt.pyetesor.domain.User;
import com.packt.pyetesor.service.SeminarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.packt.pyetesor.domain.Category;
import com.packt.pyetesor.service.CategoryService;

@RestController
@SessionAttributes({"loguar","ques","editSeminar"})
@RequestMapping(value = "/user")
public class CategoryRestController {
	@Autowired
	private SeminarService seminarService;

	@RequestMapping(value = "/list/category" , method =RequestMethod.POST)
	public List<Seminar> listCategory (Model model, @ModelAttribute("loguar") User userLoguar) {
		List<Seminar> c = seminarService.shfaqSeminaretPedagog(userLoguar.getUsername());
		return c;		
	}
}