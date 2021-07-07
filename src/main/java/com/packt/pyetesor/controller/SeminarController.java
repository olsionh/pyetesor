package com.packt.pyetesor.controller;
import com.packt.pyetesor.domain.Category;
import com.packt.pyetesor.domain.Seminar;
import com.packt.pyetesor.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.packt.pyetesor.domain.Test;
import com.packt.pyetesor.domain.User;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

@Controller
@RequestMapping(value = "/user")
@SessionAttributes({"loguar","editSeminar", "pedagogLoguar"})
public class SeminarController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private SeminarService seminaret;
    @Autowired
    private PostimService postimet;
    @Autowired
    private TestService testService;
    @Autowired
    private UserService userService;


    @RequestMapping("/seminaret")
    public String list(Model model, @ModelAttribute("loguar") User userLoguar) {
        if (model.containsAttribute("pedagogLoguar")) {
            model.addAttribute("seminaret", seminaret.shfaqSeminaretPedagog(userLoguar.getUsername()));
            model.addAttribute("postimeteMia", postimet.postimeteMia(userLoguar.getUserId()));
            ArrayList<Category> c = categoryService.showCategory();
            model.addAttribute("kategoria", c);
            ArrayList<Test> t = testService.showAllTestsPedagog(userLoguar.getUserId());
            model.addAttribute("testet", t);
            return "seminaret";
        }
        else
            return "redirect:/user/seminareteMia";
    }

    @RequestMapping(value = "/seminareteMia")
    public String seminareteMia(Model model, @ModelAttribute("loguar") User userLoguar) {
        model.addAttribute("seminareteMia", seminaret.seminareteMia(userLoguar.getUserId()));
        return "seminareteMia";
    }


    @RequestMapping(value = "/seminar/{seminarID}", method = RequestMethod.GET)
    public String editTest(Model model, @PathVariable("seminarID") int seminarId, @ModelAttribute("loguar") User userLoguar, RedirectAttributes redirectAttributes) {
        String emri = seminaret.emriPedagogut(seminarId);
        model.addAttribute("emriPedagogut", emri);
        Seminar t = seminaret.findSeminarPedagog(seminarId, userLoguar.getUsername());
        if (t == null) {
            Seminar s = seminaret.findSeminarStudent(seminarId, userLoguar.getUserId());
            if (s == null) {
                redirectAttributes.addFlashAttribute("gabim", "true");
                return "redirect:/user/faqjakryesore";
            }
            model.addAttribute("editSeminar", s);
            int nr = seminaret.nrStudenteve(seminarId);
            System.out.println(nr);
            model.addAttribute("nrStudenteve", nr);
            int nrp = seminaret.nrPostimeve(seminarId);
            model.addAttribute("nrPostimeve", nrp);
            model.addAttribute("nrTesteve", seminaret.nrTesteve(seminarId));
            ArrayList<Test> testKurs = testService.testetKurs(seminarId);
            model.addAttribute("testkurs", testKurs);
            return "menaxhoSeminar";
        }
        model.addAttribute("shtoperdorues", userService.listoPerdoruesit());
        model.addAttribute("hiqperdorues", userService.showUsersPerSeminar(seminarId));
        model.addAttribute("editSeminar", t);
        int nr = seminaret.nrStudenteve(seminarId);
        System.out.println(nr);
        model.addAttribute("nrStudenteve", nr);
        int nrp = seminaret.nrPostimeve(seminarId);
        model.addAttribute("nrPostimeve", nrp);
        model.addAttribute("nrTesteve", seminaret.nrTesteve(seminarId));
        return "menaxhoSeminarAdmin";

    }

    @RequestMapping(value = "/seminar/perdoruesit/{seminarId}", method = RequestMethod.GET)
    public String listPerdoruesit(Model model, @PathVariable("seminarId") int seminarId, RedirectAttributes redirectAttributes) {

        if (model.containsAttribute("pedagogLoguar")) {
            ArrayList<User> perdoruesit = userService.showUsersPerSeminar(seminarId);
            model.addAttribute("perdorues", perdoruesit);


            //Seminar t = seminaret.findSeminarPedagog(seminarId, userLoguar.getUsername());
            //model.addAttribute("editSeminar", t);
            int nr = seminaret.nrStudenteve(seminarId);
            System.out.println(nr);
            model.addAttribute("nrStudenteve", nr);
            int nrp = seminaret.nrPostimeve(seminarId);
            model.addAttribute("nrPostimeve", nrp);
            model.addAttribute("nrTesteve", seminaret.nrTesteve(seminarId));
            return "listoStudentet";

        }

        else
            return "redirect:/user/faqjakryesore";

    }




    @RequestMapping(value = "/seminar/testet/{seminarId}", method = RequestMethod.GET)
    public String listTestet(Model model, @PathVariable("seminarId") int seminarId, RedirectAttributes redirectAttributes, @ModelAttribute("loguar") User userLoguar) {

        Seminar t = seminaret.findSeminarPedagog(seminarId, userLoguar.getUsername());
        ArrayList<Test> perdoruesit = testService.testetKurs(seminarId);
        model.addAttribute("test", perdoruesit);
        if (t == null) {
            Seminar s = seminaret.findSeminarStudent(seminarId, userLoguar.getUserId());
            if (s == null) {
                redirectAttributes.addFlashAttribute("gabim", "true");
                return "redirect:/user/faqjakryesore";
            }
            model.addAttribute("editSeminar", s);
            int nr = seminaret.nrStudenteve(seminarId);
            System.out.println(nr);
            model.addAttribute("nrStudenteve", nr);
            int nrp = seminaret.nrPostimeve(seminarId);
            model.addAttribute("nrPostimeve", nrp);
            model.addAttribute("nrTesteve", seminaret.nrTesteve(seminarId));
            ArrayList<Test> testKurs = testService.testetKurs(seminarId);
            model.addAttribute("testkurs", testKurs);
            return "listoTestetPerdorues";
        }

        model.addAttribute("editSeminar", t);
        int nr = seminaret.nrStudenteve(seminarId);
        System.out.println(nr);
        model.addAttribute("nrStudenteve", nr);
        int nrp = seminaret.nrPostimeve(seminarId);
        model.addAttribute("nrPostimeve", nrp);
        model.addAttribute("nrTesteve", seminaret.nrTesteve(seminarId));
        return "listoTestet";
    }






    @RequestMapping(value = "/krijoKurs", method = RequestMethod.GET)
    public String krijoKurs(Model model) {
        if (model.containsAttribute("pedagogLoguar")) {
            Seminar seminar1 = new Seminar();
            model.addAttribute("newKurs", seminar1);


            return "shotKurs";
        }
        else
            return "redirect:/user/faqjakryesore";
    }

    @RequestMapping(value = "/krijoKurs" , method =RequestMethod.POST)
    public String shtoPedagog(@ModelAttribute("newKurs") Seminar newSeminar, @ModelAttribute("pedagogLoguar") User userLoguar, Model model, BindingResult result) {

        seminaret.shtoKurs(newSeminar, userLoguar.getUsername());

        return "redirect:/user/krijoKurs";
    }



}
