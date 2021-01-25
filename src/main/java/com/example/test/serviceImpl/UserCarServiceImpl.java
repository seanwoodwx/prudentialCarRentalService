package com.example.test.serviceImpl;

import com.example.test.bean.UserCarBean;
import com.example.test.mapper.UserCarMapper;
import com.example.test.service.UserCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCarServiceImpl implements UserCarService {
    @Autowired
    UserCarMapper userCarMapper;

    public UserCarBean getUserCar(Integer userId, Integer carId) {
        return userCarMapper.getUserCar(userId, carId);
    }

    public int insertUserCar(UserCarBean userCarBean) {
        return userCarMapper.insertUserCar(userCarBean);
    }

    public int updateUserCar(UserCarBean userCarBean) {
        return userCarMapper.updateUserCar(userCarBean);

    }

    public List<UserCarBean> getAllUserCar(Integer userId) {
        return userCarMapper.getAllUserCar(userId);
    }
}
