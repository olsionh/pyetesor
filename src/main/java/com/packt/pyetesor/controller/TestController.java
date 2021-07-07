package com.packt.pyetesor.controller;
import com.packt.pyetesor.domain.Seminar;
import com.packt.pyetesor.service.SeminarService;
import com.packt.pyetesor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.packt.pyetesor.domain.Test;
import com.packt.pyetesor.domain.User;
import com.packt.pyetesor.service.TestService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

@Controller
@RequestMapping(value = "/user")
@SessionAttributes({"loguar","test", "pedagogLoguar", "userLoguar"})
public class TestController {
	@Autowired
	private TestService testService;
	@Autowired
	private SeminarService seminaret;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/krijoPyetesor1", method = RequestMethod.GET)
	public String krijoPyetesor(Model model) {
		if (model.containsAttribute("pedagogLoguar")) {
			Test newTest = new Test();
			model.addAttribute("newTest", newTest);
			return "startCreateTest";
		}

		else
			return "redirect:/user/faqjakryesore";
	}

	@RequestMapping(value = "/krijoPyetesor1", method = RequestMethod.POST)
	public String getTestName(Model model, @ModelAttribute("newTest") Test newTest, @ModelAttribute("loguar") User userLoguar) {
		int tId = testService.addTest(newTest.getTestName(), newTest.getCategoryName(), userLoguar.getUserId());
		if (tId != 0) {
			Test t = new Test();
			t.setTestId(tId);
			t.setTestName(newTest.getTestName());
			model.addAttribute("test", t);
			return "redirect:/user/krijoPyetesor2";
		} else {
			return "startCreateTest";
		}
	}

	@RequestMapping(value = "/krijoPyetesor2", method = RequestMethod.GET)
	public String krijoPYETJE(Model model, @ModelAttribute("test") Test testi) {
		if (model.containsAttribute("pedagogLoguar")) {
			model.addAttribute("testi", testi);
			return "selektimiPyetjeve";
		}
		else
			return "redirect:/user/faqjakryesore";
	}

	@RequestMapping(value = "/krijoPyetesor2", method = RequestMethod.POST)
	public String nextKrijoPYETJE(Model model) {
		model.addAttribute("stringa", "testi u krijua me sukses");
		return "sukses";
	}

	@RequestMapping(value = "/admin/testekrijuara", method = RequestMethod.GET)
	public String testKrijuara(Model model) {
		return "testekrijuara";
	}

	@RequestMapping(value = "/edit/test/{testID}", method = RequestMethod.GET)
	public String editTest(Model model, @PathVariable("testID") int testId) {
		if (model.containsAttribute("pedagogLoguar")) {
			Test t = testService.findTest(testId);
			model.addAttribute("editTest", t);
			return "editoTest";
		}
		else
			return "redirect:/user/faqjakryesore";
	}

	@RequestMapping(value = "/edit/test/{testID}", method = RequestMethod.POST)
	public String updateTest(Model model, @ModelAttribute("editTest") Test t) {
		if (model.containsAttribute("pedagogLoguar")) {
			String a = testService.updateTest(t);
			model.addAttribute("stringa", a);
			return "sukses";
		}
		else
			return "redirect:/user/faqjakryesore";
	}

	//-----------------
	@RequestMapping(value = "/do/test/{testID}", method = RequestMethod.GET)
	public String doTest(Model model, @PathVariable("testID") int testId, @ModelAttribute("loguar") User userLoguar, RedirectAttributes redirectAttributes) {
		if (model.containsAttribute("userLoguar")) {
			Test t = testService.findTest(testId);
			model.addAttribute("editTest", t);
			model.addAttribute("kursi", seminaret.findSeminar(t.getCategoryName()));
			if (userService.eshteDheneProvimi(userLoguar.getUserId(), testId)) {
				redirectAttributes.addFlashAttribute("error", "true");
				return "redirect:/user/faqjakryesore";
			} else
				return "berjaProvimit";
		}
		else
			return "redirect:/user/faqjakryesore";
	}

	@RequestMapping(value = "/test/{testID}", method = RequestMethod.GET)
	public String rezultat(Model model, @PathVariable("testID") int testId)
	{
		if (model.containsAttribute("pedagogLoguar"))
		{
			model.addAttribute("results", testService.rezultatet(testId));
			return "rezultatet";
		}
		else
			return "redirect:/user/faqjakryesore";
	}


}
