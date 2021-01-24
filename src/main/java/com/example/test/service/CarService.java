package com.example.test.service;

import com.example.test.bean.CarBean;

import java.util.List;

/**
 * @功能名称:
 * @Date: 2021-01-24
 * @Author: wuxuan
 * @Copyright（C）: 2014-2021 X-Financial Inc.   All rights reserved.
 * 注意：本内容仅限于小赢科技有限责任公司内部传阅，禁止外泄以及用于其他的商业目的。
 */
public interface CarService {


    List<CarBean> getAllCar();

    int rentCar(int carId);

    int returnCar(int carId);
}
