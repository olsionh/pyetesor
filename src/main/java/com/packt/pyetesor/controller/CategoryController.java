package com.packt.pyetesor.controller;
import com.packt.pyetesor.domain.Category;
import com.packt.pyetesor.domain.Seminar;
import com.packt.pyetesor.service.CategoryService;
import com.packt.pyetesor.service.SeminarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.packt.pyetesor.domain.Test;
import com.packt.pyetesor.domain.User;
import com.packt.pyetesor.service.TestService;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

@Controller
@RequestMapping(value = "/user")
@SessionAttributes({"userLoguar","editSeminar"})
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private SeminarService seminaret;
    @Autowired
    private TestService testService;



    @RequestMapping(value = "/category/{categoryID}", method = RequestMethod.GET)
    public String editTest(Model model, @PathVariable("categoryID") int categoryId) {

        Category c = categoryService.findCategory(categoryId);
        model.addAttribute("category", c);
       // ArrayList<Test> t = testService.showTestsPerCategory(categoryId);
       // model.addAttribute("testetkategori", t);
        ArrayList<Category> c2 = categoryService.showCategory();
        model.addAttribute("kategoria", c2);
        ArrayList<Test> t2 = testService.showAllTests();
        model.addAttribute("testet", t2);
        return "menaxhoKategori";
    }

}
