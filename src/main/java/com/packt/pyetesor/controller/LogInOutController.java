package com.packt.pyetesor.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.packt.pyetesor.service.RegisterService;
import com.packt.pyetesor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.packt.pyetesor.domain.User;
import com.packt.pyetesor.service.LogInOutService;

@Controller
@RequestMapping("/user")
@SessionAttributes({"userLoguar", "adminLoguar", "adminLogin", "pedagogLoguar", "loguar", "pedagogLogin"})
public class LogInOutController {
	@Autowired
	private LogInOutService logInOutService;
	@Autowired
	private RegisterService registerService;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login" , method =	RequestMethod.GET)
	public String register (Model model,HttpServletRequest request) {
		//HttpSession session = request.getSession(false);
		//if(session==null ){
			User user = new User();
			model.addAttribute("user", user);
			model.addAttribute("newUser", user);
			return "login";
		/*}
		else{
			return "redirect:/user/profil";
		}*/
	}
	
	@RequestMapping(value = "/login" , method =	RequestMethod.POST, params = "login")
	public String ok(@ModelAttribute("user") User user,Model model) {//meret objeti nga forma e logimit 
		User perdorues = logInOutService.exists(user);//kthen emrin e perdoruesit qe ndodhet ne databaz , ekziston ,
		if(perdorues == null){
			model.addAttribute("error", "true");
			return "login";
		}
		else{
			model.addAttribute("loguar", perdorues);
			if (perdorues.getRole().equals("admin")) {
				model.addAttribute("adminLogin", "true");
				return "redirect:/user/loginadmin";
			}

			if (perdorues.getRole().equals("pedagog"))
			{
				if (userService.loginPerHereTePare(perdorues.getUserId()))
				{
					model.addAttribute("pedagogLogin", "true");
					return "redirect:/user/loginpedagog";
				}
				model.addAttribute("pedagogLoguar", perdorues);
				return "redirect:/user/faqjakryesore";
			}
			else {
				model.addAttribute("userLoguar", perdorues);// vendoset sesioni
				return "redirect:/user/faqjakryesore";
			}
		}
	}


	@RequestMapping(value = "/profil" , method =RequestMethod.GET)
	public String profili (Model model,HttpSession session,@ModelAttribute("loguar") User userLoguar) {
		if(session.getAttribute("loguar") == null){
			model.addAttribute("error", "true");
			return "login";// nuk esht vendosur sesioni ktjem loginin
		}
		if(userLoguar.getUsername().equalsIgnoreCase("admin"))
			return "profilAdmini";
		else
			return "profilUserStandart";
	}
	@RequestMapping(value = "/logout" , method =RequestMethod.GET)
	public String logout (HttpSession session,Model model,RedirectAttributes redirectAttributes,SessionStatus status) {
		session.invalidate();
		status.setComplete();
		redirectAttributes.addFlashAttribute("logout", "true");
		return "redirect:/user/login";
	}

	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
		binder.setAllowedFields("username","password","email","lastName","firstName", "register");
	}

	@RequestMapping(value = "/login" , method =	RequestMethod.POST, params = "register")
	public String processAddNewProductForm(@ModelAttribute("newUser") User newUser,Model model, BindingResult result, RedirectAttributes redirectAttributes) {
		String[] suppressedFields = result.getSuppressedFields();
		if (suppressedFields.length > 0) {
			throw new RuntimeException("Attempting to bind disallowed fields: " +
					StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}
		String emri = registerService.addUser(newUser);
		if(emri!=null){
			model.addAttribute("emri", emri);

		}
		else{
			model.addAttribute("pergjigje", "ju nuk mund t regjistroheni , nje gabim ka ndodhur. ");
		}

		redirectAttributes.addFlashAttribute("regjistruar", "true");
		return "redirect:/user/login";
	}

}
