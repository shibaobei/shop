package com.shop.service;

import com.shop.dao.AdminDao;
import com.shop.entity.AdminUser;

/**
 * Created by Administrator on 2017-10-28.
 */
public interface AdminService {
    public AdminUser login(AdminUser adminUser);
}
