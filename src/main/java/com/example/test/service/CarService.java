package com.example.test.service;

import com.example.test.bean.CarBean;

import java.util.List;


public interface CarService {


    List<CarBean> getAllCar();

    CarBean getOne(int carId);

    int rentCar(int carId);

    int returnCar(int carId);
}
