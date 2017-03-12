package com.yisutech.erp.cms.framework.http;

import java.io.Serializable;

/**
 * Created by guangzhong.wgz on 17/3/11.
 */
public class SlingResponse implements Serializable {
    private static final long serialVersionUID = -4180024813321726403L;
    /**
     * sling返回结果集
     */
    private int statusCode;
    /**
     * 返回内容
     */
    private String content;
    /**
     * 消息
     */
    private String message;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
