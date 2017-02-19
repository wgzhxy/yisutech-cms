package com.yisutech.erp.cms.framework.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by guangzhong.wgz on 17/2/18.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping("/index")
    public String home() {
        return "index";
    }
}
