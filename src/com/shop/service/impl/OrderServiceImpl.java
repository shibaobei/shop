package com.shop.service.impl;

import com.shop.dao.OrderDao;
import com.shop.entity.Order;
import com.shop.entity.OrderItem;
import com.shop.service.OrderService;
import com.shop.util.PageBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017-10-27.
 */
@Service("orderService")
@Transactional(readOnly = false)
public class OrderServiceImpl implements OrderService{
    @Resource(name="orderDao")
    private OrderDao orderDao;

    @Override
    public void save(Order order) {
        orderDao.save(order);
    }

    @Override
    public PageBean<Order> findByUid(Integer uid, Integer page) {
        PageBean<Order> pageBean = new PageBean<Order>();
        // 设置当前页数:
        pageBean.setPage(page);
        // 设置每页显示记录数:
        // 显示5个
        int limit = 5;
        pageBean.setLimit(limit);
        // 设置总记录数:
        int totalCount = 0;
        totalCount = orderDao.findCountByUid(uid);
        pageBean.setTotalCount(totalCount);
        // 设置总页数
        int totalPage = 0;
        if(totalCount % limit == 0){
            totalPage = totalCount / limit;
        }else{
            totalPage = totalCount / limit + 1;
        }
        pageBean.setTotalPage(totalPage);
        // 设置每页显示数据集合:
        int begin = (page - 1)*limit;
        List<Order> list = orderDao.findPageByUid(uid,begin,limit);
        pageBean.setList(list);
        return pageBean;
    }

    @Override
    public Order findByOid(Integer oid) {
        return orderDao.findByOid(oid);
    }

    @Override
    public void update(Order currOrder) {
        orderDao.update(currOrder);
    }

    @Override
    public PageBean<Order> findAll(Integer page) {
        PageBean<Order> pageBean = new PageBean<Order>();
        // 设置参数
        pageBean.setPage(page);
        // 设置每页显示的记录数:
        int limit = 10;
        pageBean.setLimit(limit);
        // 设置总记录数
        int totalCount = orderDao.findCount();
        pageBean.setTotalCount(totalCount);
        // 设置总页数
        int totalPage = 0;
        if(totalCount % limit == 0){
            totalPage = totalCount / limit;
        }else{
            totalPage = totalCount / limit + 1;
        }
        pageBean.setTotalPage(totalPage);
        // 设置每页显示数据集合
        int begin = (page - 1) * limit;
        List<Order> list = orderDao.findByPage(begin,limit);
        pageBean.setList(list);
        return pageBean;
    }

    @Override
    public List<OrderItem> findOrderItem(Integer oid) {
        return orderDao.findOrderItem(oid);
    }
}
