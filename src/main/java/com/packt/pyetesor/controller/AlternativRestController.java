package com.packt.pyetesor.controller;
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.packt.pyetesor.domain.Alternativ;
import com.packt.pyetesor.domain.Question;
import com.packt.pyetesor.domain.User;
import com.packt.pyetesor.service.AlternativeService;

@RestController
@RequestMapping(value = "/user")
@SessionAttributes({"loguar","ques"})
public class AlternativRestController {
	@Autowired
	private AlternativeService alternativeService;
	
	@RequestMapping(value = "/show/alternative" , method =RequestMethod.POST)
	public ArrayList<Alternativ> createAlternative (Model model,@ModelAttribute("ques") Question question) {
		ArrayList<Alternativ> alt = alternativeService.showAlternatives(question.getQuestionId());
		return alt;	
	}
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/shtoAlternativ" , method =RequestMethod.POST)
	public void addAlternative (Model model,HttpServletRequest request,@ModelAttribute("ques") Question question) {
		String a = "";
		Map<String, String[]> map = request.getParameterMap();
		for(String paramName:map.keySet()) {
            String[] paramValues = map.get(paramName);
            a=paramName;
        }
		alternativeService.addAlternative(a,question.getQuestionId());
	}
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/save/alternativSakt" , method =RequestMethod.POST)
	public String saveAlterntiveSakt (Model model,HttpServletRequest request,@ModelAttribute("ques") Question question) {
		String a = "";
		Map<String, String[]> map = request.getParameterMap();
		for(String paramName:map.keySet()) {
            String[] paramValues = map.get(paramName);
            a=paramName;
        }
		alternativeService.saveAlternativeSakt(a,question.getQuestionId());
		return "ok";
	}
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/save/alternativSakt/tipiPOJO" , method =RequestMethod.POST)
	public String saveAlterntiveSaktTipiPOJO (Model model,HttpServletRequest request,@ModelAttribute("ques") Question question) {
		String a = "";
		Map<String, String[]> map = request.getParameterMap();
		for(String paramName:map.keySet()) {
            String[] paramValues = map.get(paramName);
            a=paramName;
        }
		alternativeService.saveAlternativeSaktTypePOJO(a,question.getQuestionId());
		return "ok";
	}

	@RequestMapping(value = "/afisho/AlternativatPerPyetje" , method =	RequestMethod.POST)
	public ArrayList<Alternativ>  lisAlternativesPerPyetje (HttpServletRequest request,Model model,@ModelAttribute("loguar") User userLoguar) {
		String a = "";
		Map<String, String[]> map = request.getParameterMap();
		for(String paramName:map.keySet()) {
            String[] paramValues = map.get(paramName);
            a=paramName;
        }
		ArrayList<Alternativ> rr=alternativeService.showAlternativesPerQuestion(a);
		/*for(Alternativ atl : rr){
			System.out.println(atl.getAlternativ());
		}*/
		return rr;	
	}
	
	
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/delete/alternativ" , method =RequestMethod.POST)
	public String deleteAlternative (Model model,HttpServletRequest request) {
		String a = "";
		Map<String, String[]> map = request.getParameterMap();
		for(String paramName:map.keySet()) {
            String[] paramValues = map.get(paramName);
            a=paramName;
        }
		String b = alternativeService.deleteAlternative(a);
		return b;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
