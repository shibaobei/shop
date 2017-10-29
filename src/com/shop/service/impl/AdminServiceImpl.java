package com.shop.service.impl;

import com.shop.dao.AdminDao;
import com.shop.entity.AdminUser;
import com.shop.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017-10-28.
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService{
    @Resource(name="adminDao")
    private AdminDao adminDao;
    @Override
    public AdminUser login(AdminUser adminUser) {
        return adminDao.login(adminUser);
    }
}
