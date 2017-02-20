package com.yishtech.erp.cms.biz.sling.impl;

import com.alibaba.fastjson.JSON;
import com.yishtech.erp.cms.biz.sling.HttpClientService;
import com.yishtech.erp.cms.biz.sling.SlingCurdService;
import com.yisutech.erp.cms.framework.http.HttpClientUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * Created by guangzhong.wgz on 17/2/20.
 */
public class HttpClientServiceImpl implements HttpClientService {

    private static Logger LOG = LoggerFactory.getLogger(HttpClientServiceImpl.class);

    /**
     * POST请求资源
     *
     * @param resourcePath 资源地址
     * @param properties   资源属性
     * @return
     */
    @Override
    public String postRequest(String resourcePath, Map<String, Object> properties) {
        String rspContent = "";
        try {
            rspContent = HttpClientUtil.postContent(resourcePath, properties);
        } catch (Throwable e) {
            LOG.error("postRequest error, resourcePath {}, properties : {}",
                    resourcePath, JSON.toJSONString(properties));
        }
        return rspContent;
    }

    /**
     * POST请求资源
     *
     * @param resourcePath 资源地址
     * @param properties   资源属性
     * @param upFiles      上传文件
     * @return
     */
    @Override
    public String postRequest(String resourcePath, Map<String, Object> properties, Map<String, File> upFiles) {
        String rspContent = "";
        try {
            rspContent = HttpClientUtil.postContent(resourcePath, properties, upFiles);
        } catch (Throwable e) {
            LOG.error("postRequest error, resourcePath {}, properties : {}", resourcePath, JSON.toJSONString(properties));
        }
        return rspContent;
    }

    /**
     * POST请求资源
     *
     * @param resourcePath  资源地址
     * @param properties    资源属性
     * @param upFiles       上传文件
     * @param authorization basic Authorization
     * @return
     */
    @Override
    public String postRequest(String resourcePath, Map<String, Object> properties, Map<String, File> upFiles, String authorization) {
        String rspContent = "";
        try {
            rspContent = HttpClientUtil.postContent(resourcePath, properties, upFiles, authorization);
        } catch (Throwable e) {
            LOG.error("postRequest error, resourcePath {}, properties : {}", resourcePath, JSON.toJSONString(properties));
        }
        return rspContent;
    }
}
