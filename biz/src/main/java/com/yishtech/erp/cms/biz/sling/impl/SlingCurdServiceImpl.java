package com.yishtech.erp.cms.biz.sling.impl;

import com.yishtech.erp.cms.biz.sling.HttpClientService;
import com.yishtech.erp.cms.biz.sling.SlingCurdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by guangzhong.wgz on 17/2/20.
 */
@Service
public class SlingCurdServiceImpl implements SlingCurdService {

    @Resource
    private HttpClientService httpClientService;

    @Override
    public String addResource(String resourcePath, Map<String, Object> resourceProperties) {
        return httpClientService.postRequest(resourcePath, resourceProperties);
    }

    @Override
    public String getResource(String resourcePath) {
        return httpClientService.postRequest(resourcePath);
    }

    @Override
    public String delResource(String resourcePath) {
        return httpClientService.postRequest(resourcePath);
    }

    @Override
    public List<String> queryResources(String query) {
        return null;
    }
}
