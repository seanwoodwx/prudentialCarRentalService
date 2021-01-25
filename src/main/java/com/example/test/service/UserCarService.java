package com.example.test.service;

import com.example.test.bean.UserCarBean;

import java.util.List;


public interface UserCarService {

    UserCarBean getUserCar(Integer userId, Integer carId);

    int insertUserCar(UserCarBean userCarBean);

    int updateUserCar(UserCarBean userCarBean);

    List<UserCarBean> getAllUserCar(Integer userId);
}
