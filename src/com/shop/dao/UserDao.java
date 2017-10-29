package com.shop.dao;

import com.shop.entity.User;

/**
 * Created by Administrator on 2017-10-26.
 */
public interface UserDao<T> extends BaseDao<T>{
    public User findByUsername(String username);
    public User findByCode(String code);
    public User login(User user);
}
