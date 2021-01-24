package com.example.test.serviceImpl;

import com.example.test.bean.UserCarBean;
import com.example.test.mapper.UserCarMapper;
import com.example.test.service.UserCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @功能名称:
 * @Date: 2021-01-24
 * @Author: wuxuan
 * @Copyright（C）: 2014-2021 X-Financial Inc.   All rights reserved.
 * 注意：本内容仅限于小赢科技有限责任公司内部传阅，禁止外泄以及用于其他的商业目的。
 */
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
