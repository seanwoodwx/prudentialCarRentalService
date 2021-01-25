package com.example.test.mapper;

import com.example.test.bean.CarBean;
import com.example.test.bean.UserCarBean;

import java.util.List;

public interface CarMapper {

    List<CarBean> getAllCar();

    CarBean getOne(int carId);

    int rentCar(int carId);

    int returnCar(int carId);
}
