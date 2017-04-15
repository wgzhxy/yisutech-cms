import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.yisutech.erp.cms.core.sling.HttpClientService;
import com.yisutech.erp.cms.core.sling.impl.HttpClientServiceImpl;
import com.yisutech.erp.cms.framework.http.SlingResponse;
import com.yisutech.erp.cms.framework.utils.FwConstant;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.io.File;
import java.net.URLDecoder;
import java.util.Map;

/**
 * Created by guangzhong.wgz on 17/3/9.
 */
public class HttpClientServiceTest {

    private static Logger LOG = LoggerFactory.getLogger(HttpClientServiceTest.class);
    private HttpClientService httpClientService = new HttpClientServiceImpl();


    @Test
    public void postRequest_uri_path_properties() {
        String uri = "/content/mynode";
        Map<String, Object> properties = Maps.newConcurrentMap();
        properties.put("sling:resourceType", "foo/bar");
        properties.put("title", "this is title");
        properties.put("body", "这是测试的主要内容，看看今天故事是怎么样的");
        SlingResponse response = httpClientService.postRequest(uri, properties);

        LOG.info(JSON.toJSONString(response));
        Assert.notNull(response);
        Assert.isTrue(response.getStatusCode() != 500);
    }

    @Test
    public void get_uri_path() {
        try {
            String uri = "/content/mynode.json";
            SlingResponse slingResponse = httpClientService.getRequest(uri);
            Assert.notNull(slingResponse);
            Assert.isTrue(slingResponse.getStatusCode() != 500);

            String str = URLDecoder.decode(slingResponse.getContent(), FwConstant.UTF_8);
            Assert.notNull(str);

            JSONObject json = JSON.parseObject(str);
            LOG.info(json.toJSONString());
            Assert.notNull(json.getString("body"));

        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    @Test
    public void postRequest_uri_path_properties_files() {
        String uri = "/content/myFiles";
        Map<String, Object> properties = Maps.newConcurrentMap();
        properties.put("sling:resourceType", "foo/file");
        properties.put("title", "this is title");
        // properties.put("*@TypeHint", "nt:file");
        properties.put("body", "这是测试的主要内容，看看今天故事是怎么样的files");
        Map<String, File> files = Maps.newConcurrentMap();
        files.put("repository.xml", new File("/Users/guangzhong.wgz/antWorkSpace/yisutech-cms/repository.xml"));
        files.put("repository_old.xml", new File("/Users/guangzhong.wgz/antWorkSpace/yisutech-cms/repository_old.xml"));
        files.put("workspace.xml", new File("/Users/guangzhong.wgz/antWorkSpace/yisutech-cms/workspace.xml"));
        files.put("app.war", new File("/Users/guangzhong.wgz/antWorkSpace/yisutech-cms/app/target/app.war"));

        SlingResponse slingResponse = httpClientService.postRequest(uri, properties, files);
        Assert.notNull(slingResponse);
        Assert.isTrue(slingResponse.getStatusCode() != 500);
        LOG.info(JSON.toJSONString(slingResponse));
    }

    @Test
    public void postRequest_uri_path_file() {
        String uri = "/content/myFiles/repository.xml";
        SlingResponse slingResponse = httpClientService.getRequest(uri);
        Assert.notNull(slingResponse);
        Assert.isTrue(slingResponse.getStatusCode() != 500);
        LOG.info(JSON.toJSONString(slingResponse));
    }

    @Test
    public void getRequest_uri_path_properties_files() {
        String uri = "/content/myFiles.json";
        try {
            SlingResponse slingResponse = httpClientService.getRequest(uri);
            Assert.notNull(slingResponse);
            Assert.isTrue(slingResponse.getStatusCode() != 500);

            String str = URLDecoder.decode(slingResponse.getContent(), FwConstant.UTF_8);
            Assert.notNull(str);
            LOG.info(str);
        } catch (Throwable e) {
            e.printStackTrace();
        }

    }
}
