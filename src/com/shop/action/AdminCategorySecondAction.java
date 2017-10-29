package com.shop.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shop.entity.Category;
import com.shop.entity.CategorySecond;
import com.shop.service.CategorySecondService;
import com.shop.service.CategoryService;
import com.shop.util.PageBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017-10-27.
 */
@Controller("adminCategorySecondAction")
@Scope("prototype")
public class AdminCategorySecondAction extends ActionSupport implements ModelDriven<CategorySecond> {

    // 模型驱动使用的对象
    private CategorySecond categorySecond = new CategorySecond();
    public CategorySecond getModel() {
        return categorySecond;
    }

    // 注入二级Service
    @Resource(name = "categorySecondService")
    private CategorySecondService categorySecondService;
    // 注入一级分类的Service
    @Resource(name = "categoryService")
    private CategoryService categoryService;
    // 接收page参数:
    private Integer page;
    public void setPage(Integer page) {
        this.page = page;
    }


    // 带有分页的查询所有二级分类的操作:
    public String findAll() {
        // 调用Service进行查询.
        PageBean<CategorySecond> pageBean = categorySecondService
                .findByPage(page);
        // 将pageBean的数据存入到值栈中.
        ActionContext.getContext().getValueStack().set("pageBean", pageBean);
        return "findAll";
    }

    // 跳转到天津页面的方法:
    public String addPage() {
        // 查询所有一级分类.
        List<Category> cList = categoryService.findAll();
        // 将集合存入到值栈中.
        ActionContext.getContext().getValueStack().set("cList", cList);
        // 页面跳转:
        return "addPage";
    }

    // 添加二级分类的方法:
    public String save() {
        categorySecondService.save(categorySecond);
        return "saveSuccess";
    }

    // 删除二级分类的方法:
    public String delete() {
        categorySecondService.delete(categorySecond);
        return "deleteSuccess";
    }

    // 编辑二级分类的方法:
    public String edit() {
        // 根据id查询二级分类:
        categorySecond = categorySecondService.findByCsid(categorySecond
                .getCsid());
        // 查询所有一级分类:
        List<Category> cList = categoryService.findAll();
        // 将集合存入到值栈中.
        ActionContext.getContext().getValueStack().set("cList", cList);
        // 页面跳转:
        return "editSuccess";
    }

    // 修改二级分类的方法:
    public String update(){
        categorySecondService.update(categorySecond);
        return "updateSuccess";
    }
}
