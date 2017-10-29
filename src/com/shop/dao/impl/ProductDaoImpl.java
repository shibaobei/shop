package com.shop.dao.impl;

import com.shop.dao.ProductDao;
import com.shop.entity.Product;
import com.shop.util.PageHibernateCallback;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017-10-26.
 */
@Repository("productDao")
public class ProductDaoImpl extends BaseDaoImpl<Product> implements ProductDao<Product>{
    @Override
    public List<Product> findHot() {
        // 使用离线条件查询.
        DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
        // 查询热门的商品,条件就是is_host = 1
        criteria.add(Restrictions.eq("is_hot", 1));
        // 倒序排序输出:
        criteria.addOrder(Order.desc("pdate"));
        // 执行查询:
        List<Product> list = this.hibernateTemplate.findByCriteria(
                criteria, 0, 10);
        return list;
    }

    @Override
    public List<Product> findNew() {
        // 使用离线条件查询:
        DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
        // 按日期进行倒序排序:
        criteria.addOrder(Order.desc("pdate"));
        // 执行查询:
        List<Product> list = this.hibernateTemplate.findByCriteria(criteria, 0, 10);
        return list;
    }

    @Override
    public Product findByPid(Integer pid) {
        return this.hibernateTemplate.get(Product.class, pid);
    }

    @Override
    public int findCountCid(Integer cid) {
        String hql = "select count(*) from Product p where p.categorySecond.category.cid = ?";
        List<Long> list = this.hibernateTemplate.find(hql,cid);
        if(list != null && list.size() > 0){
            return list.get(0).intValue();
        }
        return 0;
    }

    @Override
    public List<Product> findByPageCid(Integer cid, int begin, int limit) {
        // select p.* from category c,categorysecond cs,product p where c.cid = cs.cid and cs.csid = p.csid and c.cid = 2
        // select p from Category c,CategorySecond cs,Product p where c.cid = cs.category.cid and cs.csid = p.categorySecond.csid and c.cid = ?
        String hql = "select p from Product p join p.categorySecond cs join cs.category c where c.cid = ?";
        // 分页另一种写法:
        List<Product> list = this.hibernateTemplate.execute(new PageHibernateCallback<Product>(hql, new Object[]{cid}, begin, limit));
        if(list != null && list.size() > 0){
            return list;
        }
        return null;
    }

    @Override
    public int findCountCsid(Integer csid) {
        String hql = "select count(*) from Product p where p.categorySecond.csid = ?";
        List<Long> list = this.hibernateTemplate.find(hql, csid);
        if(list != null && list.size() > 0){
            return list.get(0).intValue();
        }
        return 0;
    }

    @Override
    public List<Product> findByPageCsid(Integer csid, int begin, int limit) {
        String hql = "select p from Product p join p.categorySecond cs where cs.csid = ?";
        List<Product> list = this.hibernateTemplate.execute(new PageHibernateCallback<Product>(hql, new Object[]{csid}, begin, limit));
        if(list != null && list.size() > 0){
            return list;
        }
        return null;
    }

    @Override
    public int findCount() {
        String hql = "select count(*) from Product ";
        List<Long> list = this.hibernateTemplate.find(hql);
        if(list != null && list.size() > 0){
            return list.get(0).intValue();
        }
        return 0;
    }

    @Override
    public List<Product> findByPage(int begin, int limit) {
        String hql = "select p from Product p join p.categorySecond cs ";
        List<Product> list = this.hibernateTemplate.execute(new PageHibernateCallback<Product>(hql, new Object[]{}, begin, limit));
        if(list != null && list.size() > 0){
            return list;
        }
        return null;
    }

}
