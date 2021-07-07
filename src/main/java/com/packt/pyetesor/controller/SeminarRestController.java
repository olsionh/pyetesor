package com.packt.pyetesor.controller;
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.packt.pyetesor.domain.Postim;
import com.packt.pyetesor.domain.Seminar;
import com.packt.pyetesor.dto.SeminarDTO;
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
@SessionAttributes({"loguar","editSeminar"})
@RequestMapping(value = "/user")
public class SeminarRestController {
    @Autowired
    private TestService testService;
    @Autowired
    SeminarService seminarService;

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/delete/seminar" , method =RequestMethod.POST)
    public void cregjistrim(@ModelAttribute("loguar") User userLoguar,  Model model ,HttpServletRequest request, HttpServletResponse response) {
        String a = "";
        Map<String, String[]> map = request.getParameterMap();
        for (String paramName : map.keySet()) {
            String[] paramValues = map.get(paramName);
            a = paramName;
        }//mund t perdoresh nje klas , dhe perdor vtm fushen qe do , duhet emri i njejt. shife prap n internet. ato qe perdor , ato fjal t jen ne korenspodnet me fushat e klases qe do perdorim si objekt mbajtes
        seminarService.cregjistrim(a,userLoguar.getUserId());
    }

    @RequestMapping(value = "/list/seminaretemia" , method =RequestMethod.POST)
    public ArrayList<Seminar> seminareteMia (Model model, @ModelAttribute("loguar") User userLoguar) {
        ArrayList<Seminar> t = seminarService.seminareteMia(userLoguar.getUserId());
        return t;
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/add/userseminar" , method =RequestMethod.POST)
    public void shtoPerdorues(@ModelAttribute("editSeminar") Seminar seminar,  Model model ,HttpServletRequest request, HttpServletResponse response) {
        String a = "";
        Map<String, String[]> map = request.getParameterMap();
        for (String paramName : map.keySet()) {
            String[] paramValues = map.get(paramName);
            a = paramName;
        }
        seminarService.shtoPerdorues(a,seminar.getSeminarId());
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/delete/userseminar" , method =RequestMethod.POST)
    public void hiqPerdorues(@ModelAttribute("editSeminar") Seminar seminar,  Model model ,HttpServletRequest request, HttpServletResponse response) {
        String a = "";
        Map<String, String[]> map = request.getParameterMap();
        for (String paramName : map.keySet()) {
            String[] paramValues = map.get(paramName);
            a = paramName;
        }
        seminarService.hiqPerdorues(a);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/delete/seminaret" , method =RequestMethod.POST)
    public void fshiSeminar(@ModelAttribute("loguar") User userLoguar,  Model model ,HttpServletRequest request, HttpServletResponse response) {
        String a = "";
        Map<String, String[]> map = request.getParameterMap();
        for (String paramName : map.keySet()) {
            String[] paramValues = map.get(paramName);
            a = paramName;
        }
        seminarService.fshiSeminar(a);
    }

    @RequestMapping(value = "/gjej/seminar" , method =RequestMethod.POST)
    public Seminar merrSeminarin (Model model, int seminarId) {
        Seminar t = seminarService.findSeminar(seminarId);
        return t;
    }


}
