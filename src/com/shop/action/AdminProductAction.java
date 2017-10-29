package com.shop.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shop.entity.Product;
import com.shop.service.ProductService;
import com.shop.util.PageBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017-10-29.
 */
@Controller("adminOrderAction")
@Scope("prototype")
public class AdminProductAction extends ActionSupport implements ModelDriven<Product>{
// 模型驱动使用的类
    private Product product = new Product();
    public Product getModel(){
            return product;
    }
    @Resource(name="productService")
    private ProductService productService;

    private Integer page;
    public Integer getPage() {
        return page;
    }
    public void setPage(Integer page) {
        this.page = page;
    }

    public String findAll(){
        PageBean<Product> pageBean = productService.findByPage(this.page);
        ActionContext.getContext().put("pageBean",pageBean);
        return "findAll";
    }



}
