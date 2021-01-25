package com.example.test.mapper;

import com.example.test.bean.UserBean;

import java.util.List;

public interface UserMapper {

    UserBean getInfo(String name,String password);

    UserBean selectUserById(String id);

    int insertUser(UserBean userBean);

    int deleteUser(String id);

    int updateUser(UserBean userBean);

    List<UserBean> getAllUser();

}
