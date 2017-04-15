package com.yisutech.erp.cms.core.sling;

import com.yisutech.erp.cms.framework.http.SlingResponse;

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
    public SlingResponse getRequest(String resourcePath);

    /**
     * POST请求资源
     *
     * @param resourcePath 资源地址
     * @param params       资源属性
     * @return
     */
    public SlingResponse getRequest(String resourcePath, Map<String, Object> params);

    /**
     * POST请求资源
     *
     * @param resourcePath 资源地址
     * @param headers      头信息
     * @param params       资源属性
     * @return
     */
    public SlingResponse getRequest(String resourcePath, Map<String, Object> headers, Map<String, Object> params);


    /**
     * POST请求资源
     *
     * @param resourcePath 资源地址
     * @return
     */
    public SlingResponse postRequest(String resourcePath);

    /**
     * POST请求资源
     *
     * @param resourcePath 资源地址
     * @param properties   资源属性
     * @return
     */
    public SlingResponse postRequest(String resourcePath, Map<String, Object> properties);

    /**
     * POST请求资源
     *
     * @param resourcePath 资源地址
     * @param properties   资源属性
     * @param upFiles      上传文件
     * @return
     */
    public SlingResponse postRequest(String resourcePath, Map<String, Object> properties, Map<String, File> upFiles);

    /**
     * POST请求资源
     *
     * @param resourcePath  资源地址
     * @param properties    资源属性
     * @param upFiles       上传文件
     * @param authorization basic Authorization
     * @return
     */
    public SlingResponse postRequest(String resourcePath, Map<String, Object> properties, Map<String, File> upFiles, String authorization);
}
