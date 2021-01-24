package com.example.test.controller;

import com.example.test.bean.CarBean;
import com.example.test.bean.UserBean;
import com.example.test.bean.UserCarBean;
import com.example.test.service.CarService;
import com.example.test.service.UserCarService;
import com.example.test.service.UserService;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @功能名称:
 * @Date: 2021-01-24
 * @Author: wuxuan
 * @Copyright（C）: 2014-2021 X-Financial Inc.   All rights reserved.
 * 注意：本内容仅限于小赢科技有限责任公司内部传阅，禁止外泄以及用于其他的商业目的。
 */
@Controller
public class CarController {
    @Autowired
    CarService carService;

    @Autowired
    UserCarService userCarService;

    @Autowired
    UserService userService;


    @Transactional
    @RequestMapping(value = "/rentCar",method = RequestMethod.POST)
    @ResponseBody
    public Map rentCar(Integer carId, Integer userId, HttpServletRequest request){
        UserBean userBean;
        if((userBean = userService.checkUser(request)) == null) {
            throw new InternalException("用户未登录");
        }
        Map<String,Object> map = new HashMap<>();
        CarBean car = carService.getOne(carId);
        if(car == null || car.getCurrentCount() <= 0) {
            throw new InternalException("无此车辆，不能再借");
        }
        carService.rentCar(carId);
        UserCarBean userCar;
        userCar = userCarService.getUserCar(userBean.getId(), carId);
        if(userCar == null) {
            userCar = new UserCarBean();
            userCar.setCarId(carId);
            userCar.setUserId(userBean.getId());
            userCar.setCount(1);
            userCarService.insertUserCar(userCar);
        } else {
            userCar.setCount(userCar.getCount() + 1);
            userCarService.updateUserCar(userCar);
        }
        map.put("msg","租借成功");
        map.put("ret","0");
        return map;

    }

    @Transactional
    @RequestMapping(value = "/returnCar",method = RequestMethod.POST)
    @ResponseBody
    public Map returnCar(Integer carId, Integer userId, HttpServletRequest request){
        UserBean userBean;
        if((userBean = userService.checkUser(request)) == null) {
            throw new InternalException("用户未登录");
        }
        Map<String,Object> map = new HashMap<>();
        UserCarBean userCar = userCarService.getUserCar(userBean.getId(), carId);
        if(userCar == null || userCar.getCount() < 0 ) {
            throw new InternalException("该用户未租借此车");
        } else {
            userCar.setCount(userCar.getCount() - 1);
            userCarService.updateUserCar(userCar);
        }
        carService.returnCar(carId);

        map.put("msg","归还成功");
        map.put("ret","0");
        return map;
    }
}
