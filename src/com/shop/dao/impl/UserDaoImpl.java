package com.shop.dao.impl;

import com.shop.dao.UserDao;
import com.shop.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017-10-26.
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao<User> {
    // 按名次查询是否有该用户:
    public User findByUsername(String username) {
        String hql = "from User where username = ?";
        List<User> list = this.hibernateTemplate.find(hql, username);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
    // 根据激活码查询用户
    public User findByCode(String code) {
        String hql = "from User where code = ?";
        List<User> list = this.hibernateTemplate.find(hql, code);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    // 用户登录的方法
    public User login(User user) {
        String hql = "from User where username = ? and password = ? and state = ?";
        List<User> list = this.hibernateTemplate.find(hql,
                user.getUsername(), user.getPassword(), 1);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
}
