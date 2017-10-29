package com.shop.dao.impl;

import com.shop.dao.OrderDao;
import com.shop.entity.Order;
import com.shop.entity.OrderItem;
import com.shop.util.PageHibernateCallback;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017-10-27.
 */
@Repository("orderDao")
public class OrderDaoImpl extends BaseDaoImpl<Order> implements OrderDao<Order> {

    // Dao层的保存订单额操作
    public void save(Order order) {
        this.hibernateTemplate.save(order);
    }

    // Dao层查询我的订单分页查询:统计个数
    public int findCountByUid(Integer uid) {
        String hql = "select count(*) from Order o where o.user.uid = ?";
        List<Long> list = this.hibernateTemplate.find(hql, uid);
        if (list != null && list.size() > 0) {
            return list.get(0).intValue();
        }
        return 0;
    }

    // Dao层查询我的订单分页查询:查询数据
    public List<Order> findPageByUid(Integer uid, int begin, int limit) {
        String hql = "from Order o where o.user.uid = ? order by o.ordertime desc";
        List<Order> list = this.hibernateTemplate.execute(
                new PageHibernateCallback<Order>(hql, new Object[] { uid },
                        begin, limit));
        if (list != null && list.size() > 0) {
            return list;
        }
        return null;
    }

    // DAO层根据订单id查询订单
    public Order findByOid(Integer oid) {
        return this.hibernateTemplate.get(Order.class, oid);
    }

    // DAO层修改订单的方法:
    public void update(Order currOrder) {
        this.hibernateTemplate.update(currOrder);
    }

    // DAO中统计订单个数的方法
    public int findCount() {
        String hql = "select count(*) from Order";
        List<Long> list = this.hibernateTemplate.find(hql);
        if (list != null && list.size() > 0) {
            return list.get(0).intValue();
        }
        return 0;
    }

    // DAO中分页查询订单的方法
    public List<Order> findByPage(int begin, int limit) {
        String hql = "from Order order by ordertime desc";
        List<Order> list = this.hibernateTemplate.execute(
                new PageHibernateCallback<Order>(hql, null, begin, limit));
        return list;
    }

    // DAo中根据订单id查询订单项
    public List<OrderItem> findOrderItem(Integer oid) {
        String hql = "from OrderItem oi where oi.order.oid = ?";
        List<OrderItem> list = this.hibernateTemplate.find(hql, oid);
        if (list != null && list.size() > 0) {
            return list;
        }
        return null;
    }
}
