package com.packt.pyetesor.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.packt.pyetesor.domain.Question;
import com.packt.pyetesor.domain.User;
import com.packt.pyetesor.service.QuestionService;

@Controller
@RequestMapping(value = "/user")
@SessionAttributes({"userLoguar","ques","adminLoguar", "pedagogLoguar"})
public class QuestionController  {
	@Autowired
	private QuestionService questionService;
	
	@RequestMapping(value = "/create/question" , method =RequestMethod.GET)
	public String createQuestion (Model model) {
		if (model.containsAttribute("pedagogLoguar")) {
			model.addAttribute("newQuestion", new Question());
			return "startCreateQuestions";
		}
		else
			return "redirect:/user/faqjakryesore";
	}
	@RequestMapping(value = "/create/question" , method =RequestMethod.POST)
	public String insertQuestion (Model model, @ModelAttribute("pedagogLoguar") User userLoguar,@ModelAttribute("newQuestion") Question newQuestion) {
		int qId = questionService.addQuestion(newQuestion,userLoguar.getUserId());
		if(qId!=0){
			Question q = new Question();
			q.setType(newQuestion.getType());
			q.setQuestionId(qId);
			model.addAttribute("ques",q);
			if(newQuestion.getType()==1 || newQuestion.getType()==2){
				return "redirect:/user/create/alternative";
			}
			else if(newQuestion.getType()==3) {
				return "redirect:/user/finish/alternative/slide";
			}
			else{
				return "redirect:/user/finish/alternative/typepojo";
			}
		}
		else{
			return "Nje gabim ka ndodhur ";
		}
	}
	@RequestMapping(value = "/edit/pyetje/{questionID}" , method =RequestMethod.GET)
	public String editPyetje(Model model,@PathVariable("questionID") int questionId) {
    	Question q = questionService.findQuestion(questionId); 	
    	model.addAttribute("editQuestion",q);
		return "editoPyetje";
	}
	@RequestMapping(value = "/edit/pyetje/{questionID}" , method =RequestMethod.POST)
	public String updateQuestion(Model model,@ModelAttribute("editQuestion") Question q) {
    	String a = questionService.updateQuestion(q);
    	model.addAttribute("stringa",a);
		return "sukses";
	}
	//-------------------------------------------------------------------------
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
