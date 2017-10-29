package com.shop.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shop.entity.AdminUser;
import com.shop.service.AdminService;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017-10-28.
 */
@Controller("adminUserAction")
@Scope("prototype")
public class AdminUserAction extends ActionSupport implements ModelDriven<AdminUser> {
    // 模型驱动使用的对象
    private AdminUser adminUser = new AdminUser();

    public AdminUser getModel() {
        return adminUser;
    }
    // 注入AdminUserService
    @Resource(name = "adminService")
    private AdminService adminUserService;

    // 后台登录的执行的方法
    public String login() {
        // 调用service方法完成登录
        AdminUser existAdminUser = adminUserService.login(adminUser);
        // 判断
        if (existAdminUser == null) {
            // 用户名或密码错误
            this.addActionError("用户名或密码错误!");
            return "loginFail";
        } else {
            // 登录成功:
            ServletActionContext.getRequest().getSession()
                    .setAttribute("existAdminUser", existAdminUser);
            return "loginSuccess";
        }
    }
}
