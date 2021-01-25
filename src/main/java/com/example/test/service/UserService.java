package com.example.test.service;

import com.example.test.bean.UserBean;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {

    UserBean checkUser(HttpServletRequest request);

    UserBean loginIn(String name,String password);

    boolean loginOut(UserBean userBean);

    UserBean queryUserById(String id);

    int addUser(UserBean userBean);

    int dropUser(String id);

    int modifyUser(UserBean userBean);

    List<UserBean> queryAllUser();

}
