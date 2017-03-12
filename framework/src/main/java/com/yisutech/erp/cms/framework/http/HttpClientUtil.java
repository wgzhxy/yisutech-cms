package com.yisutech.erp.cms.framework.http;

import com.yisutech.erp.cms.framework.utils.FwConstant;
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

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * HttpClient方法请求sling服务
 *
 * @author guangzhong.wgz
 */
public class HttpClientUtil {

    private static PoolingHttpClientConnectionManager cm = null;
    private static String UTF_8 = "UTF-8";

    static {
        if (cm == null) {
            cm = new PoolingHttpClientConnectionManager();
            cm.setMaxTotal(50);
            cm.setDefaultMaxPerRoute(5);
        }
    }

    /**
     * @param url
     * @return
     */
    public static SlingResponse getContent(String url) {
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;");
        httpGet.setHeader("Accept-Language", "zh-cn");
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.0.3) Gecko/2008092417 Firefox/3.0.3");
        httpGet.setHeader("Accept-Charset", "utf-8");
        httpGet.setHeader("Keep-Alive", "300");
        httpGet.setHeader("Connection", "Keep-Alive");
        httpGet.setHeader("Cache-Control", "no-cache");
        httpGet.setHeader("Referer", "localhost");
        return getResult(httpGet);
    }

    public static SlingResponse getContent(String url, Map<String, Object> params, HttpClientContext context) throws URISyntaxException {
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

        return getResult(httpGet, context);
    }

    public static SlingResponse getContent(String url, Map<String, Object> headers, Map<String, Object> params)
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

    public static SlingResponse postContent(String url) {
        HttpPost httpPost = new HttpPost(url);
        return getResult(httpPost);
    }

    public static SlingResponse postContent(String url, Map<String, Object> params) throws UnsupportedEncodingException {
        HttpPost httpPost = new HttpPost(url);
        ArrayList<NameValuePair> pairs = covertParams2NVPS(params);
        httpPost.setEntity(buildMultipartEntity(pairs));
        initHeader(httpPost);
        return getResult(httpPost);
    }

    public static SlingResponse postContent(String url, Map<String, Object> params, Map<String, File> files) throws UnsupportedEncodingException {
        HttpPost httpPost = new HttpPost(url);
        ArrayList<NameValuePair> pairs = covertParams2NVPS(params);
        httpPost.setEntity(buildMultipartEntityFiles(pairs, files));
        initHeader(httpPost);
        return getResult(httpPost);
    }

    public static SlingResponse postContent(String url, Map<String, Object> params, Map<String, File> files, String authorization)
            throws UnsupportedEncodingException {
        HttpPost httpPost = new HttpPost(url);
        ArrayList<NameValuePair> pairs = covertParams2NVPS(params);
        httpPost.setEntity(buildMultipartEntityFiles(pairs, files));
        initHeader(httpPost);
        return getResult(httpPost);
    }

    public static SlingResponse postContentWithHeader(String url, Map<String, Object> headers, Map<String, Object> params)
            throws UnsupportedEncodingException {
        HttpPost httpPost = new HttpPost(url);
        for (Map.Entry<String, Object> param : headers.entrySet()) {
            httpPost.addHeader(param.getKey(), String.valueOf(param.getValue()));
        }
        ArrayList<NameValuePair> pairs = covertParams2NVPS(params);
        httpPost.setEntity(new UrlEncodedFormEntity(pairs, UTF_8));
        return getResult(httpPost);
    }

    /**
     * @param params
     * @return
     */
    public static HttpEntity buildMultipartEntity(List<NameValuePair> params) {
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE); //如果有SocketTimeoutException等情况，可修改这个枚举
        builder.setCharset(Charset.forName("UTF-8"));
        //不要用这个，会导致服务端接收不到参数
        if (params != null && params.size() > 0) {
            for (NameValuePair p : params) {
                builder.addTextBody(p.getName(), p.getValue(), ContentType.TEXT_PLAIN.withCharset("UTF-8"));
            }

        }
        return builder.build();
    }

    /**
     * @param params
     * @param files
     * @return
     */
    public static HttpEntity buildMultipartEntityFiles(List<NameValuePair> params, final Map<String, File> files) {
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

    /**
     * @param params
     * @param inputStreams
     * @return
     */
    public static HttpEntity buildMultipartEntityInputStream(List<NameValuePair> params, final Map<String, InputStream> inputStreams) {
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE); //如果有SocketTimeoutException等情况，可修改这个枚举
        builder.setCharset(Charset.forName("UTF-8"));
        //不要用这个，会导致服务端接收不到参数
        if (params != null && params.size() > 0) {
            for (NameValuePair p : params) {
                builder.addTextBody(p.getName(), p.getValue(), ContentType.TEXT_PLAIN.withCharset("UTF-8"));
            }

        }
        if (inputStreams != null && inputStreams.size() > 0) {
            Set<Map.Entry<String, InputStream>> entries = inputStreams.entrySet();
            for (Map.Entry<String, InputStream> entry : entries) {
                // builder.addPart(entry.getKey(), new InputStreamBody(entry.getValue()));
            }
        }
        return builder.build();

    }

    private static void initHeader(HttpRequestBase httpRequestBase) {
        httpRequestBase.setHeader("Authorization", "Basic YWRtaW46YWRtaW4=");
        httpRequestBase.setHeader("Accept", "*/*");
    }

    private static void initHeader(HttpRequestBase httpRequestBase, String authorization) throws UnsupportedEncodingException {
        httpRequestBase.setHeader("Authorization", "Basic " + Base64.encodeBase64String(authorization.getBytes(FwConstant.UTF_8)));
        httpRequestBase.setHeader("Accept", "*/*");
    }

    /**
     * 通过连接池获取HttpClient
     *
     * @return
     */
    private static synchronized CloseableHttpClient getHttpClient() {
        //我们可以使用一个Builder来设置UA字段，然后再创建HttpClient对象
        HttpClientBuilder builder = HttpClients.custom().setConnectionManager(cm);
        //对照UA字串的标准格式理解一下每部分的意思
        builder.setUserAgent("Mozilla/5.0(Windows;U;Windows NT 5.1;en-US;rv:0.9.4)");
        return builder.build();
    }

    private static ArrayList<NameValuePair> covertParams2NVPS(Map<String, Object> params) {
        ArrayList<NameValuePair> pairs = new ArrayList<NameValuePair>();
        try {
            for (Map.Entry<String, Object> param : params.entrySet()) {
                pairs.add(new BasicNameValuePair(param.getKey(), URLEncoder.encode(String.valueOf(param.getValue()), FwConstant.UTF_8)));
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return pairs;
    }

    /**
     * 处理Http请求
     *
     * @param request
     * @return
     */
    private static SlingResponse getResult(HttpRequestBase request) {
        SlingResponse slingResp = new SlingResponse();
        CloseableHttpClient httpClient = getHttpClient();
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(request);
            initSlingResponse(response, slingResp);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return slingResp;
    }

    /**
     * 处理Http请求
     *
     * @param request
     * @return
     */
    private static SlingResponse getResult(HttpRequestBase request, HttpClientContext context) {
        SlingResponse slingResp = new SlingResponse();
        CloseableHttpClient httpClient = getHttpClient();
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(request, context);
            initSlingResponse(response, slingResp);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return slingResp;
    }

    /**
     * 通过连接池获取HttpClient
     *
     * @return
     */
    private static void initSlingResponse(CloseableHttpResponse response, SlingResponse slingResp) {
        try {
            if (response != null) {
                // 请求状态
                slingResp.setStatusCode(response.getStatusLine().getStatusCode());
                slingResp.setMessage(response.getStatusLine().getReasonPhrase());
                // 解晰内容
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    slingResp.setContent(EntityUtils.toString(entity));
                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
} 