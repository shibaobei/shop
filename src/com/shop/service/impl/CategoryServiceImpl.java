package com.shop.service.impl;

import com.shop.dao.CategoryDao;
import com.shop.entity.Category;
import com.shop.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017-10-26.
 */
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService{
    @Resource(name="categoryDao")
    private CategoryDao categoryDao;
    // 业务层查询所有一级分类的方法
    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    @Override
    @Transactional(readOnly = false)
    public void save(Category category) {
        categoryDao.save(category);
    }

    @Override
    public Category findByCid(Integer cid) {
        return categoryDao.findByCid(cid);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Category category) {
        categoryDao.delete(category);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(Category category) {
        categoryDao.update(category);
    }

}
