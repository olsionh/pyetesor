package com.packt.pyetesor.controller;
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.packt.pyetesor.domain.Koment;
import com.packt.pyetesor.service.KomentService;
import com.packt.pyetesor.service.SeminarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.packt.pyetesor.domain.Test;
import com.packt.pyetesor.domain.User;
import com.packt.pyetesor.dto.TestDTO;
import com.packt.pyetesor.service.TestService;

@RestController
@SessionAttributes({"loguar","test"})
@RequestMapping(value = "/user")
public class KomentRestController {
    @Autowired
    KomentService komentService;


    @RequestMapping(value = "/list/komentet" , method =RequestMethod.POST)
    public ArrayList<Koment> shfaqKomentet (Model model,HttpServletRequest request) {
        String a = "";
        Map<String, String[]> map = request.getParameterMap();
        for(String paramName:map.keySet()) {
            String[] paramValues = map.get(paramName);
            a=paramName;
        }
        ArrayList<Koment> t = komentService.shfaqKomentet(a);
        return t;
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/delete/koment" , method =RequestMethod.POST)
    public void fshiKoment(Model model ,HttpServletRequest request, HttpServletResponse response) {
        String a = "";
        Map<String, String[]> map = request.getParameterMap();
        for (String paramName : map.keySet()) {
            String[] paramValues = map.get(paramName);
            a = paramName;
        }
        komentService.fshiKoment(a);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/shto/koment" , method =RequestMethod.POST)
    public void shtoKoment(Model model ,HttpServletRequest request, HttpServletResponse response, @ModelAttribute("loguar") User userLoguar) {
        String a = "";
        Map<String, String[]> map = request.getParameterMap();
        for (String paramName : map.keySet()) {
            String[] paramValues = map.get(paramName);
            a = paramName;
        }
        komentService.shtoKoment(a, userLoguar.getUserId());
    }

}
