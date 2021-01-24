package com.example.test.controller;

import com.example.test.bean.UserBean;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    //将Service注入Web层
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String show(){
        return "login";
    }

    @RequestMapping(value = "/loginIn",method = RequestMethod.POST)
    public String login(String name,String password, HttpServletRequest request){

        if(userService.checkUser(request) != null) {
            return "mine";
        }
        UserBean userBean = userService.loginIn(name,password);
        if(userBean!=null){
            HttpSession session = request.getSession();
            session.setAttribute("username", name);
            session.setAttribute("userId", String.valueOf(userBean.getId()));
            return "success";
        }else {
            return "error";
        }
    }


    @RequestMapping(value = "/logOut",method = RequestMethod.POST)
    public String logOut(UserBean userBean, HttpServletRequest request){
        if(userService.checkUser(request) == null) {
            return "login";
        }
        HttpSession session = request.getSession();
        session.removeAttribute("username");
        session.removeAttribute("userId");
        userService.loginOut(userBean);
        return "index";
    }

}
