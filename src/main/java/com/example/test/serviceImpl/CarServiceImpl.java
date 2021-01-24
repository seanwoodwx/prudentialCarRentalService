package com.example.test.serviceImpl;

import com.example.test.bean.CarBean;
import com.example.test.mapper.CarMapper;
import com.example.test.service.CarService;
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
public class CarServiceImpl implements CarService {

    //将DAO注入Service层
    @Autowired
    CarMapper carMapper;

    public List<CarBean> getAllCar() {
        return carMapper.getAllCar();
    }

    public int  rentCar(int carId) {
        return carMapper.rentCar(carId);
    }

    public int returnCar(int carId) {
        return carMapper.returnCar(carId);
    }
}
