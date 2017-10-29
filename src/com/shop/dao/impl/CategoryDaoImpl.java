package com.shop.dao.impl;

import com.shop.dao.CategoryDao;
import com.shop.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017-10-26.
 */
@Repository("categoryDao")
public class CategoryDaoImpl extends BaseDaoImpl<Category> implements CategoryDao<Category>{

    //DAO层的查询所有一级分类的方法
    public List<Category> findAll() {
        String hql = "from Category";
        List<Category> list = this.hibernateTemplate.find(hql);
        return list;
    }

    @Override
    public void save(Category category) {
        this.hibernateTemplate.save(category);
    }

    @Override
    public Category findByCid(Integer cid) {
        return this.hibernateTemplate.get(Category.class, cid);
    }

    @Override
    public void delete(Category category) {
        this.hibernateTemplate.delete(category);
    }

    @Override
    public void update(Category category) {
        this.hibernateTemplate.update(category);
    }

}
