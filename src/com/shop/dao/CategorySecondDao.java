package com.shop.dao;

import com.shop.entity.CategorySecond;

import java.util.List;

/**
 * Created by Administrator on 2017-10-27.
 */
public interface CategorySecondDao<T> extends BaseDao<T> {
    // DAO中的统计二级分类个数的方法
    public int findCount();
    // DAO中分页查询的方法
    public List<CategorySecond> findByPage(int begin, int limit);
    // DAO中的保存二级分类的方法
    public void save(CategorySecond categorySecond);
    // DAO中的删除二级分类的方法
    public void delete(CategorySecond categorySecond);

    // DAO中根据id查询二级分类的方法
    public CategorySecond findByCsid(Integer csid);
    // DAO中的修改二级分类的方法
    public void update(CategorySecond categorySecond);
    // DAO中的查询所有二级分类的方法
    public List<CategorySecond> findAll();

}
