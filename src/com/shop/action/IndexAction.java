package com.shop.action;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Created by Administrator on 2017-10-26.
 */
@Controller("indexAction")
@Scope("prototype")
public class IndexAction extends ActionSupport{
    public String execute(){
        return "index";
    }
}
