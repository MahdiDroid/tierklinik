package com.MahdiDroid.tierklinik.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {
                        //empty string    slash    mehtod  open the html file
    @RequestMapping({"","/","index","index.html"})
    public String index(Model model){
        model.addAttribute("welcome","welcome to our clinic");
        return "index";
    }
}
