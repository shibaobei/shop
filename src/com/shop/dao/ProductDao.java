package com.shop.dao;


import com.shop.entity.Product;

import java.util.List;

/**
 * Created by Administrator on 2017-10-26.
 */

public interface ProductDao<T> extends BaseDao<T>{
    // 首页上热门商品查询
    public List<Product> findHot();
    // 首页上最新商品的查询
    public List<Product> findNew();
    // 根据商品ID查询商品
    public Product findByPid(Integer pid);
    // 根据分类id查询商品的个数
    public int findCountCid(Integer cid);
    // 根据分类id查询商品的集合
    public List<Product> findByPageCid(Integer cid, int begin, int limit);
    // 根据二级分类查询商品个数
    public int findCountCsid(Integer csid);
    // 根据二级分类查询商品信息
    public List<Product> findByPageCsid(Integer csid, int begin, int limit);
    public int findCount();
    // 根据二级分类查询商品信息
    public List<Product> findByPage( int begin, int limit);

}
