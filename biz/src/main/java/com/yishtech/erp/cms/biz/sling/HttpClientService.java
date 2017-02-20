package com.yishtech.erp.cms.biz.sling;

import java.io.File;
import java.util.Map;

/**
 * Created by guangzhong.wgz on 17/2/20.
 */
public interface HttpClientService {

    /**
     * POST请求资源
     *
     * @param resourcePath 资源地址
     * @return
     */
    public String postRequest(String resourcePath);

    /**
     * POST请求资源
     *
     * @param resourcePath 资源地址
     * @param properties   资源属性
     * @return
     */
    public String postRequest(String resourcePath, Map<String, Object> properties);

    /**
     * POST请求资源
     *
     * @param resourcePath 资源地址
     * @param properties   资源属性
     * @param upFiles      上传文件
     * @return
     */
    public String postRequest(String resourcePath, Map<String, Object> properties, Map<String, File> upFiles);

    /**
     * POST请求资源
     *
     * @param resourcePath  资源地址
     * @param properties    资源属性
     * @param upFiles       上传文件
     * @param authorization basic Authorization
     * @return
     */
    public String postRequest(String resourcePath, Map<String, Object> properties, Map<String, File> upFiles, String authorization);
}
