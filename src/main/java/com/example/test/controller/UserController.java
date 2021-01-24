package com.example.test.controller;

import com.example.test.bean.CarBean;
import com.example.test.bean.UserBean;
import com.example.test.bean.UserCarBean;
import com.example.test.service.CarService;
import com.example.test.service.UserCarService;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @功能名称:
 * @Date: 2021-01-24
 * @Author: wuxuan
 * @Copyright（C）: 2014-2021 X-Financial Inc.   All rights reserved.
 * 注意：本内容仅限于小赢科技有限责任公司内部传阅，禁止外泄以及用于其他的商业目的。
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    CarService carService;

    @Autowired
    UserCarService userCarService;

    @RequestMapping(value = "/mine")
    public String mine(HttpServletRequest request, ModelMap modelMap){
        UserBean userBean;
        if((userBean = userService.checkUser(request)) == null) {
            return "login";
        }
        List<CarBean> carList =  carService.getAllCar();

        List<UserCarBean> userCarList =  userCarService.getAllUserCar(userBean.getId());

        Map<Integer, Integer> carNumMap = new HashMap<>();
        for(UserCarBean userCar: userCarList) {
            carNumMap.put(userCar.getCarId(), userCar.getCount());
        }

        modelMap.addAttribute("carList", carList);
        modelMap.addAttribute("carNumMap", carNumMap);

        return "mine";
    }
}
