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
@SessionAttributes({"adminLoguar","editSeminar"})
public class ReportController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private SeminarService seminaret;
    @Autowired
    private UserService userService;
    @Autowired
    private TestService testService;
    @Autowired
    private PostimService postimet;

    @RequestMapping(value = "/admin/reports", method = RequestMethod.GET)
    public String reports(Model model, @ModelAttribute("loguar") User userLoguar)
    {
        if (model.containsAttribute("adminLoguar")) {
            model.addAttribute("postimeteMia", postimet.postimeteMia(userLoguar.getUserId()));
            ArrayList<Category> c = categoryService.showCategory();
            model.addAttribute("kategoria", c);
            ArrayList<Test> t = testService.showAllTests();
            model.addAttribute("testet", t);
            return "reports";
        }
        else
            return "redirect:/user/faqjakryesore";
    }

    @RequestMapping(value = "/seminaretPDF", method = RequestMethod.GET)
    public String seminaretPDF(ModelMap modelMap)
    {
        modelMap.put("listSeminaret", this.findAll());
        return "seminaretPDF";
    }

    @RequestMapping(value = "/seminaretXLS", method = RequestMethod.GET)
    public String seminaretXLS(ModelMap modelMap)
    {
        modelMap.put("listSeminaret", this.findAll());
        return "seminaretXLS";
    }

    @RequestMapping(value = "/perdoruesitPDF", method = RequestMethod.GET)
    public String perdoruesitPDF(ModelMap modelMap)
    {
        modelMap.put("listPerdoruesit", this.perdoruesit());
        return "perdoruesitPDF";
    }

    @RequestMapping(value = "/perdoruesitXLS", method = RequestMethod.GET)
    public String perdoruesitXLS(ModelMap modelMap)
    {
        modelMap.put("listPerdoruesit", this.perdoruesit());
        return "perdoruesitXLS";
    }

    @RequestMapping(value = "/rezultatetPDF", method = RequestMethod.GET)
    public String rezultatetPDF(ModelMap modelMap)
    {
        modelMap.put("listRezultatet", this.rezultatet());
        return "rezultatetPDF";
    }

    @RequestMapping(value = "/rezultatetXLS", method = RequestMethod.GET)
    public String rezultatetXLS(ModelMap modelMap)
    {
        modelMap.put("listRezultatet", this.rezultatet());
        return "rezultatetXLS";
    }

    @RequestMapping(value = "/mesataretPDF", method = RequestMethod.GET)
    public String mesataretPDF(ModelMap modelMap)
    {
        modelMap.put("listMesataret", this.mesataret());
        return "mesataretPDF";
    }

    @RequestMapping(value = "/mesataretXLS", method = RequestMethod.GET)
    public String mesataretXLS(ModelMap modelMap)
    {
        modelMap.put("listMesataret", this.mesataret());
        return "mesataretXLS";
    }




    public List<Map<String, ?>> findAll()
    {

        List<Map<String, ?>> listSeminaret =new ArrayList<Map<String, ?>>();
        for (Seminar p: seminaret.shfaqSeminaret())
        {
            Map<String, Object> m = new HashMap<String, Object>();
            m.put("seminar", p.getSeminar());
            m.put("pedagogu", p.getPedagogu());
            m.put("sesioni", p.getSesioni());
            m.put("nrstudent", seminaret.nrStudenteve(p.getSeminarId()));
            m.put("nrpost", seminaret.nrPostimeve(p.getSeminarId()));
            listSeminaret.add(m);
        }

        return listSeminaret;
    }

    public List<Map<String, ?>> perdoruesit()
    {

        List<Map<String, ?>> listPerdoruesit =new ArrayList<Map<String, ?>>();
        for (User u: userService.listoPerdoruesit())
        {
            Map<String, Object> m = new HashMap<String, Object>();
            m.put("username", u.getUsername());
            m.put("emri", u.getFirstName());
            m.put("mbiemri", u.getLastName());
            m.put("email", u.getEmail());
            listPerdoruesit.add(m);
        }

        return listPerdoruesit;
    }

    public List<Map<String, ?>> rezultatet()
    {

        List<Map<String, ?>> listRezultatet =new ArrayList<Map<String, ?>>();
        for (User u: userService.listoPerdoruesit())
        {

            for (Test t: testService.showAllTestPerUser(u.getUserId()))
            {
                Map<String, Object> m = new HashMap<String, Object>();
                m.put("username", u.getUsername());
                m.put("testname", t.getTestName());
                m.put("testcat", t.getCategoryName());
                m.put("rezultati", t.getTestScore());
                listRezultatet.add(m);
            }

        }

        return listRezultatet;
    }

    public List<Map<String, ?>> mesataret()
    {

        List<Map<String, ?>> listMesataret =new ArrayList<Map<String, ?>>();
        for (User u: userService.listoPerdoruesit())
        {
            double mes=0;
            double i=0;
            Map<String, Object> m = new HashMap<String, Object>();
            m.put("emri", u.getFirstName());
            m.put("mbiemri", u.getLastName());

            for (Test t: testService.showAllTestPerUser(u.getUserId()))
            {
                i++;
                mes+=t.getTestScore();
            }

            mes=mes/i;
            mes = Math.round(mes * 100.0) / 100.0;
            m.put("mes", mes);

            listMesataret.add(m);

        }

        return listMesataret;
    }

}
