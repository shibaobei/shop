package com.shop.service.impl;

import com.shop.dao.UserDao;
import com.shop.entity.User;
import com.shop.service.UserService;
import com.shop.util.UUIDUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017-10-26.
 */
@Service("userService")
public class UserServiceImpl implements UserService{
    @Resource(name = "userDao")
    private UserDao userDao;
    // 按用户名查询用户的方法:
    public User findByUsername(String username){
        return userDao.findByUsername(username);
    }

    @Override
    @Transactional(readOnly = false)
    public void save(User user) {
        user.setState(0);
        String code = UUIDUtils.getUUID()+UUIDUtils.getUUID();
        user.setCode(code);
        this.userDao.saveEntity(user);
    }

    // 业务层根据激活码查询用户
    public User findByCode(String code) {
        return userDao.findByCode(code);
    }
    // 修改用户的状态的方法
    public void update(User existUser) {
        userDao.updateEntity(existUser);
    }
    // 用户登录的方法
    public User login(User user) {
        return userDao.login(user);
    }
}
