package com.shop.dao.impl;

import com.shop.dao.AdminDao;
import com.shop.entity.AdminUser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017-10-28.
 */
@Repository("adminDao")
public class AdminDaoImpl extends BaseDaoImpl<AdminUser> implements AdminDao<AdminUser>{
    @Override
    public AdminUser login(AdminUser adminUser) {
        String hql = "from AdminUser where username = ? and password = ?";
        List<AdminUser> list = this.hibernateTemplate.find(hql, adminUser.getUsername(),adminUser.getPassword());
        if(list != null && list.size()>0){
            return list.get(0);
        }
        return null;
    }

}
