package com.example.test.bean;

/**
 * @功能名称:
 * @Date: 2021-01-24
 * @Author: wuxuan
 * @Copyright（C）: 2014-2021 X-Financial Inc.   All rights reserved.
 * 注意：本内容仅限于小赢科技有限责任公司内部传阅，禁止外泄以及用于其他的商业目的。
 */
public class UserCarBean {
    private int carId;
    private int userId;
    private int count;

    public int getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
