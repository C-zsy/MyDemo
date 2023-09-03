package com.chinasoft.demo.controller;

import com.chinasoft.demo.service.UserService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.*;

//@RestController
@Controller
public class IndexController extends BaseController {

    private static final Logger log= LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private UserService userService;

    @GetMapping("index")
    public String index() {
        return "index";
    }

    @GetMapping("welcome")
    public String welcome(HttpSession session) {
        return session.getAttribute("user") == null ? "redirect:/index" : "welcome";
    }

    @PostMapping("welcome")
    public String welcome(HttpServletRequest request, HttpSession session) {
        Map<String, Object> map = getParamMap(request);
        return userService.login(map, session);
    }

    @GetMapping("register")
    public String register() {
        return "user/userAdd";
    }

    @PostMapping("register")
    public String register1(HttpServletRequest request, HttpSession session) {
        Map<String, Object> map = getParamMap(request);
        return userService.register_new(map, session);
    }


}
