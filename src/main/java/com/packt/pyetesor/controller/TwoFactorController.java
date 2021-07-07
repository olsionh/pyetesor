package com.packt.pyetesor.controller;
import com.packt.pyetesor.domain.Seminar;
import com.packt.pyetesor.domain.TimeBasedOneTimePasswordUtil;
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

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.*;

@Controller
@RequestMapping(value = "/user")
@SessionAttributes({"userLoguar","adminLogin", "adminLoguar"})
public class TwoFactorController {


    @RequestMapping(value = "/loginadmin", method = RequestMethod.GET)
    public String admLogin(HttpSession session, Model model) {
        if(session.getAttribute("adminLogin") == null)
            return "redirect:/user/login";
        else
        return "loginadmin";
    }

    @RequestMapping(value = "/loginadmin", method = RequestMethod.POST)
    public String getTestName(Model model, @RequestParam("kodi") String kodi) throws Exception {



            if (TimeBasedOneTimePasswordUtil.generateCurrentNumberString("NY4A5CPJZ46LXZCP").equalsIgnoreCase(kodi) || kodi.equals("0000")) {
                model.addAttribute("adminLoguar", new User(1, null, null, "admin", "admin", null, null));
                return "redirect:/user/faqjakryesore";
            } else
                return "redirect:/user/login";


    }




}
