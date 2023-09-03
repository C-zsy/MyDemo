package com.chinasoft.demo.controller;

import com.chinasoft.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class AdminController extends BaseController {
    @Autowired
    private AdminService adminService;

    @GetMapping("roleAdd")
    public String roleAdd(HttpSession session) {
        return session.getAttribute("user") == null ? "redirect:/index" : "role/roleAdd";
    }

    @PostMapping("roleAdd")
    public String roleAdd(HttpServletRequest request, HttpSession session) {
        Map<String, Object> map = getParamMap(request);

        return adminService.roleAdd(map, session);
    }

    @GetMapping("roleList")
    public String roleList(HttpServletRequest request, HttpSession session) {
        Map<String, Object> map = getParamMap(request);
        adminService.roleList(map, session);

        return session.getAttribute("user") == null ? "redirect:/index" : "role/roleList";
    }

    @PostMapping("roleDelete")
    public String roleDelete(@RequestParam("checkone") String ids) {
        int count = adminService.roleDelete(getDeleteData(ids));

        return "redirect:/roleList";
    }

    @GetMapping("powerDetails")
    public String powerDetails(HttpServletRequest request, HttpSession session) {
        Map<String, Object> map = getParamMap(request);
        adminService.powerDetails(map, session);

        return session.getAttribute("user") == null ? "redirect:/index" : "power/powerDetails";
    }

    @GetMapping("powerList")
    public String PowerList(HttpServletRequest request, HttpSession session) {
        Map<String, Object> map = getParamMap(request);
        adminService.powerList(map, session);

        return session.getAttribute("user") == null ? "redirect:/index" : "power/powerList";
    }

    @GetMapping("rolePowerList")
    public String rolePowerList(HttpServletRequest request, HttpSession session) {
        Map<String, Object> map = getParamMap(request);
        adminService.rolePowerList(map, session);

        return session.getAttribute("user") == null ? "redirect:/index" : "rp/rolePowerList";
    }

    @GetMapping("userList")
    public String userList(HttpServletRequest request, HttpSession session) {
        Map<String, Object> map = getParamMap(request);
        adminService.userList(map, session);

        return session.getAttribute("user") == null ? "redirect:/index" : "user/userList";
    }

    @GetMapping("userUpdate")
    public String userUpdate(HttpServletRequest request, HttpSession session) {
        Map<String, Object> map = getParamMap(request);
        session.setAttribute("userUpdate", map);

        return session.getAttribute("user") == null ? "redirect:/index" : "user/userUpdate";
    }

    @PostMapping("userUpdate")
    public String userUpdate1(HttpServletRequest request, HttpSession session) {
        Map<String, Object> map = getParamMap(request);

        return adminService.userUpdate(map, session);
    }

    @PostMapping("userDelete")
    public String userDelete(@RequestParam("checkone") String ids) {
        int count = adminService.userDelete(getDeleteData(ids));

        return "redirect:/userList";
    }

    @GetMapping("backup")
    public String backup(HttpServletRequest request, HttpSession session) {
        Map<String, Object> map = getParamMap(request);
        adminService.rolePowerList(map, session);

        return session.getAttribute("user") == null ? "redirect:/index" : "backup/backup";
    }

    @PostMapping("powerDelete")
    public String powerDelete(@RequestParam("checkone") String ids) {
        int count = adminService.deleteRolePowerByIds(getDeleteData(ids));

        return "redirect:/rolePowerList";
    }

    @GetMapping("powerUpdate")
    public String PowerUpdate(HttpServletRequest request, HttpSession session) {
        Map<String, Object> map = getParamMap(request);
        adminService.powerUpdate(map, session);

        return "power/powerUpdate";
    }

    @GetMapping("rolePowerAdd")
    public String rolePowerAdd(HttpSession session) {
        return session.getAttribute("user") == null ? "redirect:/index" : "rp/rolePowerAdd";
    }

    @PostMapping("rolePowerAdd")
    public String rolePowerAdd(HttpServletRequest request, HttpSession session) {
        Map<String, Object> map = getParamMap(request);
        map = adminService.mapChange(map);

        return adminService.rolePowerAdd(map, session);
    }

    @GetMapping("rolePowerUpdate")
    public String rolePowerUpdate(HttpServletRequest request, HttpSession session) {
        Map<String, Object> map = getParamMap(request);
        session.setAttribute("rolePowerUpdate", map);

        return session.getAttribute("user") == null ? "redirect:/index" : "rp/rolePowerUpdate";
    }

    @PostMapping("rolePowerDelete")
    public String rolePowerDelete(@RequestParam("checkone") String ids) {
        int count = adminService.rolePowerDelete(getDeleteData(ids));

        return "redirect:/rolePowerList";
    }

    @PostMapping("rolePowerUpdate")
    public String rolePowerUpdate1(HttpServletRequest request, HttpSession session) {
        Map<String, Object> map = getParamMap(request);
        map = adminService.mapChange(map);

        return adminService.rolePowerUpdate(map, session);
    }

    @GetMapping("roleUpdate")
    public String roleUpdate(HttpServletRequest request, HttpSession session) {
        Map<String, Object> map = getParamMap(request);
        session.setAttribute("roleUpdate", map);

        return session.getAttribute("user") == null ? "redirect:/index" : "role/roleUpdate";
    }

    @PostMapping("roleUpdate")
    public String roleUpdate1(HttpServletRequest request, HttpSession session) {
        Map<String, Object> map = getParamMap(request);

        return adminService.roleUpdate(map, session);
    }
}
