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

@Controller
public class CarController {
    @Autowired
    CarService carService;

    @Autowired
    UserCarService userCarService;

    @Autowired
    UserService userService;


    @Transactional
    @RequestMapping(value = "/apiRentCar",method = RequestMethod.POST)
    @ResponseBody
    public Map ApiRentCar(Integer carId, HttpServletRequest request){
        //judge login state
        UserBean userBean;
        if((userBean = userService.checkUser(request)) == null) {
            throw new InternalException("please login");
        }
        Map<String,Object> map = new HashMap<>();
        //judge car num
        CarBean car = carService.getOne(carId);
        if(car == null || car.getCurrentCount() <= 0) {
            throw new InternalException("no car left");
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
        map.put("msg","rent succeed!");
        map.put("ret","0");
        return map;

    }

    @Transactional
    @RequestMapping(value = "/apiReturnCar",method = RequestMethod.POST)
    @ResponseBody
    public Map ApiReturnCar(Integer carId, HttpServletRequest request){
        //judge login state
        UserBean userBean;
        if((userBean = userService.checkUser(request)) == null) {
            throw new InternalException("please login");
        }
        Map<String,Object> map = new HashMap<>();
        //judge whether user has rented this car
        UserCarBean userCar = userCarService.getUserCar(userBean.getId(), carId);
        if(userCar == null || userCar.getCount() < 0 ) {
            throw new InternalException("you didn't rent this car");
        } else {
            userCar.setCount(userCar.getCount() - 1);
            userCarService.updateUserCar(userCar);
        }
        carService.returnCar(carId);

        map.put("msg","return succeed!");
        map.put("ret","0");
        return map;
    }
}
