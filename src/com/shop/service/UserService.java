package com.shop.service;

import com.shop.entity.User;

/**
 * Created by Administrator on 2017-10-26.
 */
public interface UserService {
    public User findByUsername(String username);
    public void save(User user);
    public User findByCode(String code);
    public void update(User existUser);
    public User login(User user);

}
