package com.shop.service.impl;

import com.shop.dao.CategorySecondDao;
import com.shop.entity.CategorySecond;
import com.shop.service.CategorySecondService;
import com.shop.util.PageBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017-10-27.
 */
@Service("categorySecondService ")
@Transactional(readOnly = false)
public class CategorySecondServiceImpl implements CategorySecondService {
    @Resource(name = "categorySecondDao")
    private CategorySecondDao categorySecondDao;


    @Override
    public PageBean<CategorySecond> findByPage(Integer page) {
        PageBean<CategorySecond> pageBean = new PageBean<CategorySecond>();

        // 设置参数:
        pageBean.setPage(page);
        // 设置每页显示记录数:
        int limit = 10;
        pageBean.setLimit(limit);
        // 设置总记录数:
        int totalCount = categorySecondDao.findCount();
        pageBean.setTotalCount(totalCount);
        // 设置总页数:
        int totalPage = 0;
        if (totalCount % limit == 0) {
            totalPage = totalCount / limit;
        } else {
            totalPage = totalCount / limit + 1;
        }
        pageBean.setTotalPage(totalPage);
        // 设置页面显示数据的集合:
        int begin = (page - 1) * limit;
        List<CategorySecond> list = categorySecondDao.findByPage(begin,limit);
        pageBean.setList(list);
        return pageBean;
    }

    @Override
    public void save(CategorySecond categorySecond) {
        categorySecondDao.save(categorySecond);
    }

    @Override
    public void delete(CategorySecond categorySecond) {
        categorySecondDao.delete(categorySecond);
    }

    @Override
    public CategorySecond findByCsid(Integer csid) {
        return categorySecondDao.findByCsid(csid);
    }

    @Override
    public void update(CategorySecond categorySecond) {
        categorySecondDao.update(categorySecond);
    }

    @Override
    public List<CategorySecond> findAll() {
        return categorySecondDao.findAll();
    }
}
