package com.shop.dao;

import com.shop.entity.AdminUser;

/**
 * Created by Administrator on 2017-10-28.
 */
public interface AdminDao<T> extends BaseDao<T> {
    // Dao完成登录的代码
    public AdminUser login(AdminUser adminUser);
}
