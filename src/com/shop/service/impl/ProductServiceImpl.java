package com.shop.service.impl;

import com.shop.dao.ProductDao;
import com.shop.entity.Product;
import com.shop.service.ProductService;
import com.shop.util.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017-10-26.
 */
@Service("productService")
public class ProductServiceImpl implements ProductService{
    @Resource(name = "productDao")
    private ProductDao productDao;


    @Override
    public List<Product> findHot() {
        return productDao.findHot();
    }

    @Override
    public List<Product> findNew() {
        return productDao.findNew();
    }

    @Override
    public Product findByPid(Integer pid) {
        return productDao.findByPid(pid);
    }

    @Override
    public PageBean<Product> findByPageCid(Integer cid, int page) {
        PageBean<Product> pageBean = new PageBean<Product>();
        // 设置当前页数:
        pageBean.setPage(page);
        // 设置每页显示记录数:
        int limit = 8;
        pageBean.setLimit(limit);
        //  设置总记录数:
        int totalCount = 0 ;
        totalCount = productDao.findCountCid(cid);
        pageBean.setTotalCount(totalCount);
        // 设置总页数:
        int totalPage = 0;
        // Math.ceil(totalCount / limit);
        if(totalCount % limit == 0){
            totalPage = totalCount / limit;
        }else{
            totalPage = totalCount / limit + 1;
        }
        pageBean.setTotalPage(totalPage);
        // 每页显示的数据集合:
        // 从哪开始:
        int begin = (page - 1) * limit;
        List<Product> list = productDao.findByPageCid(cid,begin,limit);
        pageBean.setList(list);
        return pageBean;
    }

    @Override
    public PageBean<Product> findByPageCsid(Integer csid, int page) {
        PageBean<Product> pageBean = new PageBean<Product>();
        // 设置当前页数:
        pageBean.setPage(page);
        // 设置每页显示记录数:
        int limit = 8;
        pageBean.setLimit(limit);
        //  设置总记录数:
        int totalCount = 0 ;
        totalCount = productDao.findCountCsid(csid);
        pageBean.setTotalCount(totalCount);
        // 设置总页数:
        int totalPage = 0;
        // Math.ceil(totalCount / limit);
        if(totalCount % limit == 0){
            totalPage = totalCount / limit;
        }else{
            totalPage = totalCount / limit + 1;
        }
        pageBean.setTotalPage(totalPage);
        // 每页显示的数据集合:
        // 从哪开始:
        int begin = (page - 1) * limit;
        List<Product> list = productDao.findByPageCsid(csid,begin,limit);
        pageBean.setList(list);
        return pageBean;
    }

    @Override
    public PageBean<Product> findByPage(int page) {
        PageBean<Product> pageBean = new PageBean<Product>();
        // 设置当前页数:
        pageBean.setPage(page);
        // 设置每页显示记录数:
        int limit = 8;
        pageBean.setLimit(limit);
        //  设置总记录数:
        int totalCount = 0 ;
        totalCount = productDao.findCount();
        pageBean.setTotalCount(totalCount);
        // 设置总页数:
        int totalPage = 0;
        // Math.ceil(totalCount / limit);
        if(totalCount % limit == 0){
            totalPage = totalCount / limit;
        }else{
            totalPage = totalCount / limit + 1;
        }
        pageBean.setTotalPage(totalPage);
        // 每页显示的数据集合:
        // 从哪开始:
        int begin = (page - 1) * limit;
        List<Product> list = productDao.findByPage(begin,limit);
        pageBean.setList(list);
        return pageBean;
    }
}
