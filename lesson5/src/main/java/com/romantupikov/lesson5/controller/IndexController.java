package com.romantupikov.lesson5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "redirect:noname";
    }

    @GetMapping("/{name}")
    public String hello(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }
}
