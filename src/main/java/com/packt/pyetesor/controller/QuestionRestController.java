package com.packt.pyetesor.controller;
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.packt.pyetesor.domain.Question;
import com.packt.pyetesor.domain.User;
import com.packt.pyetesor.service.QuestionService;

@RestController
@SessionAttributes({"loguar","ques"})
@RequestMapping(value = "/user")
public class QuestionRestController {
	@Autowired
	private QuestionService questionService;

	@RequestMapping(value = "/list/question" , method =RequestMethod.POST)
	public Question listQuestion (Model model,@ModelAttribute("ques") Question question) {
		Question q = questionService.showQuestion(question.getQuestionId());
		return q;		
	}
	@RequestMapping(value = "/list/AllQuestion" , method =RequestMethod.POST)
	public ArrayList<Question> listAllQuestion (Model model,@ModelAttribute("loguar") User userLoguar) {
		ArrayList<Question> q = questionService.showAllQuestion(userLoguar.getUserId());
		return q;		
	}
	@RequestMapping(value = "/fshi/pyetjeFromTest" , method =RequestMethod.POST)
	public String deleteQuestionFromTest (Model model,HttpServletRequest request) {
		String a = "";
		Map<String, String[]> map = request.getParameterMap();
		for(String paramName:map.keySet()) {
            String[] paramValues = map.get(paramName);
            a=paramName;
        }
		String b = questionService.deleteQuestionFromTest(a);
		System.out.println(b);
		return b;		
	}
	@RequestMapping(value = "/fshi/pyetjeFromDatabase" , method =RequestMethod.POST)
	public String deleteQuestionFromDatabase (Model model,HttpServletRequest request) {
		String a = "";
		Map<String, String[]> map = request.getParameterMap();
		for(String paramName:map.keySet()) {
            String[] paramValues = map.get(paramName);
            a=paramName;
        }
		String b = questionService.deleteQuestionFromDatabase(a);
		return b;		
	}
	//-------------------------------------------------------------------------------------
	/*@RequestMapping(value = "/list/questionOfTest" , method =RequestMethod.POST)
	public ArrayList<TestDTO> showQuestionOfTest(Model model,HttpServletRequest request) {
		String a = "";
		Map<String, String[]> map = request.getParameterMap();
		for(String paramName:map.keySet()) {
            String[] paramValues = map.get(paramName);
            a=paramName;
        }
		ArrayList<TestDTO> b = questionService. showQuestionOfTest(a);
		return b;		
	}*/
}
