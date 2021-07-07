package com.packt.pyetesor.controller;
import com.packt.pyetesor.domain.*;
import com.packt.pyetesor.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.*;

@Controller
@RequestMapping(value = "/user")
@SessionAttributes({"loguar","editSeminar", "pedagogLogin", "pedagogLoguar", "adminLoguar"})
public class PedagogController {
    @Autowired
    private RegisterService registerService;
    @Autowired
    private UserService userService;


    @RequestMapping(value = "/admin/shtoPedagog", method = RequestMethod.GET)
    public String shtoPedagog(Model model, @ModelAttribute("loguar") User userLoguar) {
        if (model.containsAttribute("adminLoguar")) {
            User user = new User();
            model.addAttribute("user", user);
            model.addAttribute("newUser", user);
            return "shtoPedagog";
        }
        else
            return "redirect:/user/faqjakryesore";
    }

    @InitBinder
    public void initialiseBinder(WebDataBinder binder) {
        binder.setAllowedFields("username","password","email","lastName","firstName", "register");
    }

    @RequestMapping(value = "/admin/shtoPedagog" , method =RequestMethod.POST)
    public String shtoPedagog(@ModelAttribute("newUser") User newUser,Model model, BindingResult result, RedirectAttributes redirectAttributes) {
        String[] suppressedFields = result.getSuppressedFields();
        if (suppressedFields.length > 0) {
            throw new RuntimeException("Attempting to bind disallowed fields: " +
                    StringUtils.arrayToCommaDelimitedString(suppressedFields));
        }
        String emri = registerService.shtoPedagog(newUser);
        if(emri!=null){
            model.addAttribute("emri", emri);

        }
        else{
            model.addAttribute("pergjigje", "ju nuk mund t regjistroheni , nje gabim ka ndodhur. ");
        }
        redirectAttributes.addFlashAttribute("regjistruar", "true");
        return "redirect:/user/admin/shtoPedagog";
    }

    @RequestMapping(value = "/loginpedagog", method = RequestMethod.GET)
    public String admLogin(HttpSession session, Model model) {
        if(session.getAttribute("pedagogLogin") == null)
            return "redirect:/user/login";
        else
            return "loginpedagog";
    }

    @RequestMapping(value = "/loginpedagog", method = RequestMethod.POST)
    public String getTestName(Model model, @RequestParam("newpassword") String kodi, @ModelAttribute("loguar") User userLoguar) throws Exception {


            userService.ndryshoPasswordPedagog(kodi, userLoguar.getUserId());
            model.addAttribute("pedagogLoguar", userLoguar);
            return "redirect:/user/faqjakryesore";


    }


}
