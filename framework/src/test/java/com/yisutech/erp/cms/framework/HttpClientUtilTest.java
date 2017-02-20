package com.yisutech.erp.cms.framework;

import com.google.common.collect.Maps;
import com.yisutech.erp.cms.framework.http.HttpClientUtil;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.NTCredentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.junit.*;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by guangzhong.wgz on 17/2/19.
 */
public class HttpClientUtilTest {

    private static Logger LOG = LoggerFactory.getLogger(HttpClientUtil.class);

    @Test
    public void getContent_url() {
        String url = "http://localhost:8080/content/mynode.json";
        String rspContent = HttpClientUtil.getContent(url);
        Assert.assertNotNull(rspContent);
    }

    @Test
    public void getContent_url_params() {
        String url = "http://localhost:8080/content/mynode";
        Map<String, Object> params = Maps.newHashMap();
        // curl -u admin:admin -F"sling:resourceType=foo/bar" -F"title=some title" http://localhost:8080/content/mynode
        //params.put("sling:resourceType", "foo/bar");
        params.put("title", "some title");
        params.put("text", "some title text");
        try {
            String rspContent = HttpClientUtil.postContent(url, params);
            LOG.debug("rspContent {} ", rspContent);
            Assert.assertNotNull(rspContent);
        } catch (Throwable e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void postContent_url() {
        String url = "http://www.baidu.com";
        String rspContent = HttpClientUtil.postContent(url);
        Assert.assertNotNull(rspContent);
    }
}
