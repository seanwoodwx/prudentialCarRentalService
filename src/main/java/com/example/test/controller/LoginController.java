package com.example.test.controller;

import com.example.test.bean.UserBean;
import com.example.test.service.UserService;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String show(){
        return "login";
    }

    @RequestMapping(value = "/apiLogin",method = RequestMethod.POST)
    public String apiLogin(String name,String password, HttpServletRequest request){

        if(userService.checkUser(request) != null) {
            return "mine";
        }
        UserBean userBean = userService.login(name,password);
        if(userBean!=null){
            HttpSession session = request.getSession();
            session.setAttribute("username", name);
            session.setAttribute("userId", String.valueOf(userBean.getId()));
            return "success";
        }else {
            return "error";
        }
    }


    @RequestMapping(value = "/apiLogout",method = RequestMethod.POST)
    @ResponseBody
    public Map ApiLogout(HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        if(userService.checkUser(request) == null) {
            throw new InternalException("user not login");
        }
        HttpSession session = request.getSession();
        session.removeAttribute("username");
        session.removeAttribute("userId");

        map.put("msg","logout succeed!");
        map.put("ret","0");
        return map;

    }

}
