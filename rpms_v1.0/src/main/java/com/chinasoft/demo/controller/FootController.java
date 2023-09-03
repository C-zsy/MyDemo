package com.chinasoft.demo.controller;

import com.chinasoft.demo.service.FootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class FootController extends BaseController{
    @Autowired
    private FootService footService;

    @GetMapping("connectMang")
    public String connectMang(HttpSession session) {
        return session.getAttribute("user") == null ? "redirect:/index" : "connectMang";
    }

    @GetMapping("project")
    public String project(HttpSession session) {
        return session.getAttribute("user") == null ? "redirect:/index" : "project";
    }

    @GetMapping("about")
    public String about(HttpSession session) {
        return session.getAttribute("user") == null ? "redirect:/index" : "about";
    }

    @GetMapping("onlinehelp")
    public String onlinehelp(HttpSession session) {
        return session.getAttribute("user") == null ? "redirect:/index" : "onlinehelp";
    }
}
