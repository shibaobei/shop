package com.shop.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.shop.entity.Category;
import com.shop.entity.Product;
import com.shop.service.CategoryService;
import com.shop.service.ProductService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017-10-26.
 */
@Controller("indexAction")
@Scope("prototype")
public class IndexAction extends ActionSupport{
    @Resource(name="categoryService")
    private CategoryService categoryService;
    @Resource(name="productService")
    private ProductService productService;


    public String execute(){
        // 查询所有一级分类集合
        List<Category> cList = categoryService.findAll();
        // 将一级分类存入到Session的范围:
        ActionContext.getContext().getSession().put("cList", cList);
        // 查询热门商品:
        List<Product> hList = productService.findHot();
        // 保存到值栈中:
        ActionContext.getContext().getValueStack().set("hList", hList);
        // 查询最新商品:
        List<Product> nList = productService.findNew();
        // 保存到值栈中:
       ActionContext.getContext().getValueStack().set("nList", nList);
        return "index";
    }
}
