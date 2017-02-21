package com.yisutech.erp.cms.app.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by guangzhong.wgz on 17/2/18.
 */
@Controller
public class IndexController {

    @RequestMapping("/conf/index")
    public String home() {
        System.out.println("index~~~~~~~!");
        return "cms/index";
    }

    @ResponseBody
    @RequestMapping("/conf/getConfig")
    public Object getConfig() {
        JSONObject obj = new JSONObject();
        obj.put("key", "this is test");
        obj.put("good", "myKey good");
        obj.put("jeep", "jeep test so good");
        return obj;
    }
}
