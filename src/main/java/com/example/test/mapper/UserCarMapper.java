package com.example.test.mapper;

import com.example.test.bean.UserCarBean;

import java.util.List;

public interface UserCarMapper {
    UserCarBean getUserCar(Integer userId, Integer carId);

    int insertUserCar(UserCarBean userCarBean);

    int updateUserCar(UserCarBean userCarBean);

    List<UserCarBean> getAllUserCar(Integer userId);
}
