package com.packt.pyetesor.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.packt.pyetesor.domain.Alternativ;
import com.packt.pyetesor.domain.Question;
import com.packt.pyetesor.service.AlternativeService;

@Controller
@RequestMapping(value = "/user")
@SessionAttributes({"userLoguar","ques"})
public class AlternativController {
	@Autowired
	private AlternativeService alternativeService;
	
	@RequestMapping(value = "/create/alternative" , method =RequestMethod.GET)
	public String createAlternativeTip12 (Model model) {
		return "startCreateAlternatives";	
	}
	@RequestMapping(value = "/create/alternative" , method =RequestMethod.POST)
	public String returnFinishCreateAlternativeTip12 (Model model) {
		return "redirect:/user/finish/alternative";	
	}
	@RequestMapping(value = "/finish/alternative" , method =RequestMethod.GET)
	public String finishCreationAlternativeTip12 (Model model,@ModelAttribute("ques") Question question) {
		model.addAttribute("tipi",question.getType());
		return "finishCreationAlternative";	// duhet ber ridrejtim i url pasi kjo url me duhet per t perfunduar testin 
	}
	@RequestMapping(value = "/finish/alternative" , method =RequestMethod.POST)
	public String finishSaveAlterntiveTip12 (Model model) {
		model.addAttribute("stringa","Alternativa per kete pyetje u ruajt me sukses . Ju faleminderit . Tani ju mund te krijoni teste te reja dhe mund te perfshini e kete pyetje ");
		return "sukses";	// duhet ber ridrejtim i url pasi kjo url me duhet per t perfunduar testin 
	}
	@RequestMapping(value = "/finish/alternative/typepojo" , method =RequestMethod.GET)
	public String finishAlternative(Model model,@ModelAttribute("ques") Question question) {
		return "finishiCreationAlterTypeYN";	
	}
	@RequestMapping(value = "/finish/alternative/typepojo" , method =RequestMethod.POST)
	public String finishAlternativeTypePOJO(Model model,@ModelAttribute("ques") Question question) {
		model.addAttribute("stringa","Alternativa e sakte u ruajt me sukses!");
		return "sukses";


	}
	@RequestMapping(value = "/finish/alternative/slide" , method =RequestMethod.GET)
	public String finishAlternativeTipi3(Model model,@ModelAttribute("ques") Question question) {
		return "finishCreationAlterTypeSlide";
	}
	@RequestMapping(value = "/finish/alternative/slide" , method =RequestMethod.POST)
	public String finishAlternativeTypeSLIDE(Model model,@ModelAttribute("ques") Question question) {
		model.addAttribute("stringa", "Alternativa e sakt u ruajt me sukses!");
		return "sukses";
	}
	@RequestMapping(value = "/edit/alternativ/{alternativID}" , method =RequestMethod.GET)
	public String editAlternative (Model model,@PathVariable("alternativID") int alternativID) {
		Alternativ a =alternativeService.showOnly1Alternatives(alternativID);
		model.addAttribute("alternativa",a);
		return "editoAlternativ";	
	}
	@RequestMapping(value = "/edit/alternativ/{alternativID}" , method =RequestMethod.POST)
	public String saveEditAlternative (Model model,@ModelAttribute("alternativa") Alternativ alternativa) {
		 String a = alternativeService.updateAlternative(alternativa);
		model.addAttribute("stringa",a);
		return "sukses";	
	}
	
	//-------------------------------------------------------------------	
	

	
	
	
	
	
	
	
	
	
	
}
