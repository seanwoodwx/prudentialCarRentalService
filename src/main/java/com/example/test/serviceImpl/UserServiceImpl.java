package com.example.test.serviceImpl;

import com.example.test.bean.UserBean;
import com.example.test.mapper.UserMapper;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    //将DAO注入Service层
    @Autowired
    UserMapper userMapper;

    /**
     * 登录验证
     * @param name
     * @param password
     * @return
     */
    @Override
    public UserBean loginIn(String name, String password) {
        return userMapper.getInfo(name,password);
    }

    @Override
    public boolean loginOut(UserBean userBean) {
        return true;
    }

    /**
     * 根据ID查询用户信息
     * @param id
     * @return
     */
    @Override
    public UserBean queryUserById(String id) {
        return userMapper.selectUserById(id);
    }

    @Override
    public UserBean checkUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("userId");
        if(userId == null) {
            return null;
        }
        UserBean userBean = userMapper.selectUserById(userId);
        return userBean;
    }


    /**
     * 新增用户
     * @param userBean
     * @return
     */
    @Override
    public int addUser(UserBean userBean) {
        int aFlag = userMapper.insertUser(userBean);
        return aFlag;
    }

    /**
     * 根据ID删除用户
     * @param id
     * @return
     */
    @Override
    public int dropUser(String id) {
        int dFlag = userMapper.deleteUser(id);
        return dFlag;
    }


    /**
     * 修改用户信息
     * remark：实际上还是根据用户ID修改用户信息
     * @param userBean
     * @return
     */
    @Override
    public int modifyUser(UserBean userBean) {
        int mFlag = userMapper.updateUser(userBean);
        return mFlag;
    }

    /**
     * 查询所有用户信息
     * @return
     */
    @Override
    public List<UserBean> queryAllUser() {
        return userMapper.getAllUser();
    }
}
