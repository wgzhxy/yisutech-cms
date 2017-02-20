package com.yisutech.erp.cms.framework.http;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;

import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * @author guangzhong.wgz
 */
public class HttpClientUtil {

    private static PoolingHttpClientConnectionManager cm;
    private static String EMPTY_STR = "";
    private static String UTF_8 = "UTF-8";

    /**
     * @param url
     * @return
     */
    public static String getContent(String url) {
        HttpGet httpGet = new HttpGet(url);
        return getResult(httpGet);
    }

    public static String getContent(String url, Map<String, Object> params, HttpClientContext context) throws URISyntaxException {
        URIBuilder ub = new URIBuilder();
        ub.setPath(url);

        ArrayList<NameValuePair> pairs = covertParams2NVPS(params);
        ub.setParameters(pairs);

        HttpGet httpGet = new HttpGet(ub.build());
        httpGet.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;");
        httpGet.setHeader("Accept-Language", "zh-cn");
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.0.3) Gecko/2008092417 Firefox/3.0.3");
        httpGet.setHeader("Accept-Charset", "utf-8");
        httpGet.setHeader("Keep-Alive", "300");
        httpGet.setHeader("Connection", "Keep-Alive");
        httpGet.setHeader("Cache-Control", "no-cache");
        httpGet.setHeader("Authorization", "Basic YWR2aW46YWRtaW4=");
        httpGet.setHeader("Referer", "localhost");

        return getResult(httpGet, context);
    }

    public static String getContent(String url, Map<String, Object> headers, Map<String, Object> params)
            throws URISyntaxException {
        URIBuilder ub = new URIBuilder();
        ub.setPath(url);

        ArrayList<NameValuePair> pairs = covertParams2NVPS(params);
        ub.setParameters(pairs);

        HttpGet httpGet = new HttpGet(ub.build());
        for (Map.Entry<String, Object> param : headers.entrySet()) {
            httpGet.addHeader(param.getKey(), String.valueOf(param.getValue()));
        }
        return getResult(httpGet);
    }

    public static String postContent(String url) {
        HttpPost httpPost = new HttpPost(url);
        return getResult(httpPost);
    }

    public static String postContent(String url, Map<String, Object> params) throws UnsupportedEncodingException {
        HttpPost httpPost = new HttpPost(url);
        ArrayList<NameValuePair> pairs = covertParams2NVPS(params);
        httpPost.setEntity(buildMultipartEntity(pairs, null));
        httpPost.setHeader("Authorization", "Basic YWRtaW46YWRtaW4=");
        httpPost.setHeader("Accept", "*/*");
        httpPost.setHeader("User-Agent", "curl/7.43.0");
        httpPost.setHeader("Host", "localhost:8080");
        return getResult(httpPost);
    }

    public static String postContent(String url, Map<String, Object> headers, Map<String, Object> params)
            throws UnsupportedEncodingException {
        HttpPost httpPost = new HttpPost(url);

        for (Map.Entry<String, Object> param : headers.entrySet()) {
            httpPost.addHeader(param.getKey(), String.valueOf(param.getValue()));
        }

        ArrayList<NameValuePair> pairs = covertParams2NVPS(params);

        httpPost.setEntity(new UrlEncodedFormEntity(pairs, UTF_8));


        return getResult(httpPost);
    }

    private static void init() {
        if (cm == null) {
            cm = new PoolingHttpClientConnectionManager();
            cm.setMaxTotal(50);
            cm.setDefaultMaxPerRoute(5);
        }
    }

    /**
     * 通过连接池获取HttpClient
     *
     * @return
     */
    private static synchronized CloseableHttpClient getHttpClient() {
        init();
        //我们可以使用一个Builder来设置UA字段，然后再创建HttpClient对象
        HttpClientBuilder builder = HttpClients.custom().setConnectionManager(cm);
        //对照UA字串的标准格式理解一下每部分的意思
        builder.setUserAgent("Mozilla/5.0(Windows;U;Windows NT 5.1;en-US;rv:0.9.4)");
        return builder.build();
    }

    private static ArrayList<NameValuePair> covertParams2NVPS(Map<String, Object> params) {
        ArrayList<NameValuePair> pairs = new ArrayList<NameValuePair>();
        for (Map.Entry<String, Object> param : params.entrySet()) {
            pairs.add(new BasicNameValuePair(param.getKey(), String.valueOf(param.getValue())));
        }

        return pairs;
    }

    /**
     * 处理Http请求
     *
     * @param request
     * @return
     */
    private static String getResult(HttpRequestBase request) {
        // CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpClient httpClient = getHttpClient();
        try {
            CloseableHttpResponse response = httpClient.execute(request);
            // response.getStatusLine().getStatusCode();
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                // long len = entity.getContentLength();// -1 表示长度未知
                String result = EntityUtils.toString(entity);
                response.close();
                // httpClient.close();
                return result;
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }

        return EMPTY_STR;
    }

    /**
     * 处理Http请求
     *
     * @param request
     * @return
     */
    private static String getResult(HttpRequestBase request, HttpClientContext context) {
        // CloseableHttpClient httpClient = HttpClients.createDefault();  
        CloseableHttpClient httpClient = getHttpClient();
        try {
            CloseableHttpResponse response = httpClient.execute(request, context);
            // response.getStatusLine().getStatusCode();  
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                // long len = entity.getContentLength();// -1 表示长度未知  
                String result = EntityUtils.toString(entity);
                response.close();
                // httpClient.close();  
                return result;
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }

        return EMPTY_STR;
    }

    /**
     * @param params
     * @param files
     * @return
     */
    public static HttpEntity buildMultipartEntity(List<NameValuePair> params, final Map<String, File> files) {
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE); //如果有SocketTimeoutException等情况，可修改这个枚举
        builder.setCharset(Charset.forName("UTF-8"));
        //不要用这个，会导致服务端接收不到参数
        if (params != null && params.size() > 0) {
            for (NameValuePair p : params) {
                builder.addTextBody(p.getName(), p.getValue(), ContentType.TEXT_PLAIN.withCharset("UTF-8"));
            }

        }
        if (files != null && files.size() > 0) {
            Set<Map.Entry<String, File>> entries = files.entrySet();
            for (Map.Entry<String, File> entry : entries) {
                builder.addPart(entry.getKey(), new FileBody(entry.getValue()));
            }
        }
        return builder.build();

    }

} 