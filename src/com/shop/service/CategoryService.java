package com.shop.service;

import com.shop.entity.Category;

import java.util.List;

/**
 * Created by Administrator on 2017-10-26.
 */
public interface CategoryService {
    public List<Category> findAll();
    // 业务层保存一级分类的操作
    public void save(Category category);
    // 业务层根据一级分类id查询一级分类
    public Category findByCid(Integer cid);
    // 业务层删除一级分类
    public void delete(Category category);
    // 业务层修改一级分类
    public void update(Category category);
}
