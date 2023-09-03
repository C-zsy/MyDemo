package com.chinasoft.demo.service;

import com.chinasoft.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public String login(Map<String,Object> map, HttpSession session){
        String result = "";
        Map<String,Object> dataMap = userMapper.login(map);
        if(dataMap==null){//证明账号有问题
            session.setAttribute("msg","账号有问题");
            result="redirect:/index";
        }else{
            if(!map.get("userPassword").toString().equals(dataMap.get("userPassword").toString())){
                session.setAttribute("msg","密码有问题");
                result="redirect:/index";
            }else{
                session.setAttribute("user",dataMap);
                result="redirect:/welcome";
            }
        }

        return result;
    }

    public String register_new(Map<String, Object> map, HttpSession session){
        String result = "";
        userMapper.register(map);
        session.setAttribute("user", map);
        result = "redirect:/index";

        return result;
    }


}
