package com.yisutech.erp.cms.app.controller;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by guangzhong.wgz on 17/2/18.
 */
@Controller
@RequestMapping("/home")
public class IndexController {

    private static Logger LOG = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping("index")
    public String home(ModelMap model, HttpServletRequest request) {
        model.put("contextPath", request.getContextPath());
        return "/cms/index";
    }

    @ResponseBody
    @RequestMapping("getConfig")
    public Object getConfig() {
        JSONObject obj = new JSONObject();
        obj.put("key", "this is test");
        obj.put("good", "myKey good");
        obj.put("jeep", "jeep test so good");
        LOG.info("retMessage : {}", obj.toString());
        return obj;
    }
}
