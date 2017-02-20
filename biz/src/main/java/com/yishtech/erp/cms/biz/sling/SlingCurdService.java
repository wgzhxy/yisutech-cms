package com.yishtech.erp.cms.biz.sling;

import java.util.List;
import java.util.Map;

/**
 * sling 增删改查
 * <p>
 * Created by guangzhong.wgz on 17/2/20.
 */
public interface SlingCurdService {

    /**
     * @param resourcePath       资源路径
     * @param resourceProperties 资源
     */
    public String addResource(String resourcePath, Map<String, Object> resourceProperties);

    /**
     * @param resourcePath
     * @return
     */
    public String getResource(String resourcePath);

    /**
     * @param resourcePath
     */
    public String delResource(String resourcePath);

    /**
     * @param query
     * @return
     */
    public List<String> queryResources(String query);
}
