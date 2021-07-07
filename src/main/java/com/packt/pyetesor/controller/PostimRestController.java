package com.packt.pyetesor.controller;
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.packt.pyetesor.domain.Postim;
import com.packt.pyetesor.domain.Seminar;
import com.packt.pyetesor.dto.PostimDTO;
import com.packt.pyetesor.dto.SeminarDTO;
import com.packt.pyetesor.service.PostimService;
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
public class PostimRestController {
    @Autowired
    private TestService testService;
    @Autowired
    PostimService postimService;


    @RequestMapping(value = "/list/postimetemia" , method =RequestMethod.POST)
    public ArrayList<PostimDTO> postimeteMia (Model model,@ModelAttribute("loguar") User userLoguar) {
        ArrayList<PostimDTO> t = postimService.listAllPostsPerUser(userLoguar.getUserId());
        return t;
    }

    @RequestMapping(value = "/list/postimetseminar" , method =RequestMethod.POST)
    public ArrayList<PostimDTO> postimetSeminar (Model model,@ModelAttribute("editSeminar") Seminar seminar) {
        ArrayList<PostimDTO> t = postimService.listAllPostsPerSeminar(seminar.getSeminarId());
        return t;
    }

    @RequestMapping(value = "/list/merrseminar" , method =RequestMethod.POST)
    public ArrayList<Seminar> merrSeminarin (Model model, Postim postim) {
        ArrayList<Seminar> t = postimService.merrSeminarin(postim.getPostimId());
        return t;
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/shto/postim" , method =RequestMethod.POST)
    public void shtoPostim(Model model ,HttpServletRequest request, HttpServletResponse response) {
        String a = "";
        Map<String, String[]> map = request.getParameterMap();
        for (String paramName : map.keySet()) {
            String[] paramValues = map.get(paramName);
            a = paramName;
        }
        postimService.shtoPostim(a);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/delete/postim" , method =RequestMethod.POST)
    public void fshiKoment(Model model ,HttpServletRequest request, HttpServletResponse response) {
        String a = "";
        Map<String, String[]> map = request.getParameterMap();
        for (String paramName : map.keySet()) {
            String[] paramValues = map.get(paramName);
            a = paramName;
        }
        postimService.fshiPostim(a);
    }


}
