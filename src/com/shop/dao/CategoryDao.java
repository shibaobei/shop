package com.shop.dao;

import com.shop.entity.Category;

import java.util.List;

/**
 * Created by Administrator on 2017-10-26.
 */
public interface CategoryDao<T> extends BaseDao<T>{
    public List<Category> findAll();
    // Dao中的保存一级分类的方法
    public void save(Category category);

    // Dao中根据一级分类id查询一级分类
    public Category findByCid(Integer cid);

    // DAO中删除一级分类
    public void delete(Category category);
    // Dao中修改一级分类
    public void update(Category category);


}
