package com.yishtech.erp.cms.biz.sling;

import java.util.List;
import java.util.Map;

/**
 * sling 增删改查
 * <p>
 * Created by guangzhong.wgz on 17/2/20.
 */
public interface SlingCurdService {

    public void addResource(Map<String, Object> resource);

    public Object getResource(String resourcePath);

    public void delResource(String resourcePath);

    public List<Object> queryResources(String query);
}
