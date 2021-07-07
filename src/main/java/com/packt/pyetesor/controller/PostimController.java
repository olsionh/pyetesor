package com.packt.pyetesor.controller;
import com.packt.pyetesor.domain.Category;
import com.packt.pyetesor.domain.Seminar;
import com.packt.pyetesor.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.packt.pyetesor.domain.Test;
import com.packt.pyetesor.domain.User;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

@Controller
@RequestMapping(value = "/user")
@SessionAttributes({"userLoguar","editSeminar", "pedagogLoguar", "adminLoguar", "loguar"})
public class PostimController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private PostimService postimet;
    @Autowired
    private TestService testService;
    @Autowired
    private SeminarService seminarService;
    @Autowired
    private UserService userService;




    @RequestMapping(value = "/faqjakryesore")
    public String seminareteMia(Model model, @ModelAttribute("loguar") User userLoguar) {
        model.addAttribute("postimeteMia", postimet.postimeteMia(userLoguar.getUserId()));
        model.addAttribute("kurset", seminarService.seminareteMia(userLoguar.getUserId()));
        ArrayList<Test> t = testService.testeteMia(userLoguar.getUserId());
        model.addAttribute("testet", t);

        ArrayList<Seminar> s = new ArrayList<Seminar>();
        if (t!=null) {
            int v[] = new int[t.size()];
            Seminar sem;
            for (int i = 0; i < t.size(); i++) {
                sem = seminarService.findSeminar(t.get(i).getCategoryName());
                if (userService.eshteDheneProvimi(userLoguar.getUserId(), t.get(i).getTestId()))
                    v[i] = 0;
                else
                    v[i] = 1;

                s.add(new Seminar(sem.getSeminarId(), sem.getSeminar(), sem.getPedagogu(), sem.getSesioni()));
            }

            model.addAttribute("kurs", s);
            model.addAttribute("v", v);
        }


        if (userLoguar.getRole().equals("admin"))
        return "redirect:/user/admin/shtoPedagog";
        else if (userLoguar.getRole().equals("pedagog"))
            return "redirect:/user/seminaret";
        else
            return "faqjaKryesore";
    }


}
