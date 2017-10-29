package com.shop.service;

import com.shop.entity.Product;
import com.shop.util.PageBean;

import java.util.List;

/**
 * Created by Administrator on 2017-10-26.
 */
public interface ProductService {
    // 首页上热门商品查询
    public List<Product> findHot();

    // 首页上最新商品的查询
    public List<Product> findNew();
    // 根据商品ID查询商品
    public Product findByPid(Integer pid);
    // 根据一级分类的cid带有分页查询商品
    public PageBean<Product> findByPageCid(Integer cid, int page);
    // 根据二级分类查询商品信息
    public PageBean<Product> findByPageCsid(Integer csid, int page);
    public PageBean<Product> findByPage( int page);

}
