package com.shop.dao.impl;

import com.shop.dao.CategorySecondDao;
import com.shop.entity.CategorySecond;
import com.shop.util.PageHibernateCallback;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017-10-27.
 */
@Repository("categorySecondDao")
public class CategorySecondDaoImpl extends BaseDaoImpl<CategorySecond> implements CategorySecondDao<CategorySecond >{

    @Override
    public int findCount() {
        String hql = "select count(*) from CategorySecond";
        List<Long> list = this.hibernateTemplate.find(hql);
        if (list != null && list.size() > 0) {
            return list.get(0).intValue();
        }
        return 0;
    }

    @Override
    public List<CategorySecond> findByPage(int begin, int limit) {
        String hql = "from CategorySecond order by csid desc";
        List<CategorySecond> list = this.hibernateTemplate.execute(
                new PageHibernateCallback<CategorySecond>(hql, null, begin,
                        limit));
        return list;
    }

    @Override
    public void save(CategorySecond categorySecond) {
        this.hibernateTemplate.save(categorySecond);
    }

    @Override
    public void delete(CategorySecond categorySecond) {
        this.hibernateTemplate.delete(categorySecond);;
    }

    @Override
    public CategorySecond findByCsid(Integer csid) {
        return this.hibernateTemplate.get(CategorySecond.class, csid);
    }

    @Override
    public void update(CategorySecond categorySecond) {
        this.hibernateTemplate.update(categorySecond);
    }

    @Override
    public List<CategorySecond> findAll() {
        String hql = "from CategorySecond";
        return this.hibernateTemplate.find(hql);
    }
}
