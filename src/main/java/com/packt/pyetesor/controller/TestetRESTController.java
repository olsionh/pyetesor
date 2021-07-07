package com.packt.pyetesor.controller;
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.packt.pyetesor.service.SeminarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.packt.pyetesor.domain.Test;
import com.packt.pyetesor.domain.User;
import com.packt.pyetesor.dto.TestDTO;
import com.packt.pyetesor.service.TestService;

@RestController
@SessionAttributes({"loguar","test"})
@RequestMapping(value = "/user")
public class TestetRESTController {
	@Autowired
	private TestService testService;
	
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/populate/test" , method =RequestMethod.POST)
	public  void addQuestionAndTest ( Model model ,HttpServletRequest request,@ModelAttribute("test") Test testi) {
		String a = "";
		Map<String, String[]> map = request.getParameterMap();
		for(String paramName:map.keySet()) {
            String[] paramValues = map.get(paramName);
            a=paramName;
        }
		testService.addQuestionAndTest(a,testi.getTestId());
	}
	@RequestMapping(value = "/admin/afishoAllTests" , method =	RequestMethod.POST)
	public  ArrayList<TestDTO> listALLTests (Model model,@ModelAttribute("lLoguar") User userLoguar) {
		ArrayList<TestDTO> rr=testService.listAllTests(userLoguar.getUserId());
		return rr;
	}
	@ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/delete/test" , method =RequestMethod.POST)
	public  void deleteTest ( Model model ,HttpServletRequest request, HttpServletResponse response) {
		String a = "";
		Map<String, String[]> map = request.getParameterMap();
		for(String paramName:map.keySet()) {
            String[] paramValues = map.get(paramName);
            a=paramName;
        }
        testService.deleteTest(a);
	}
	@RequestMapping(value = "/listquestion/kriterKerkimi" , method =RequestMethod.POST)
	public ArrayList<Test> listAllQuestion (Model model,HttpServletRequest request) {
		String a = "";
		Map<String, String[]> map = request.getParameterMap();
		for(String paramName:map.keySet()) {
            String[] paramValues = map.get(paramName);
            a=paramName;
        }
		ArrayList<Test> t = testService.showTestByCriteria(a);
		return t;		
	}
	@RequestMapping(value = "/list/testeTeBera" , method =RequestMethod.POST)
	public ArrayList<Test> listAllQuestionPerUser (Model model,@ModelAttribute("loguar") User userLoguar) {
		ArrayList<Test> t = testService.showAllTestPerUser(userLoguar.getUserId());
		return t;		
	}
}
