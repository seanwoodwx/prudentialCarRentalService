package com.example.test.serviceImpl;

import com.example.test.bean.CarBean;
import com.example.test.mapper.CarMapper;
import com.example.test.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarMapper carMapper;

    public List<CarBean> getAllCar() {
        return carMapper.getAllCar();
    }

    public CarBean getOne(int carId) {
        return carMapper.getOne(carId);
    }


    public int  rentCar(int carId) {
        return carMapper.rentCar(carId);
    }

    public int returnCar(int carId) {
        return carMapper.returnCar(carId);
    }
}
