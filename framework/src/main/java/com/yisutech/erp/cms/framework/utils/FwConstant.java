package com.yisutech.erp.cms.framework.utils;

import sun.util.resources.th.CalendarData_th;

/**
 * Created by guangzhong.wgz on 17/2/20.
 */
public class FwConstant {
    /**
     * 统一编码格式
     */
    public static String UTF_8 = "UTF-8";
    /**
     * Sling 服务URL
     */
    public static String SLING_SERVICE_URL = "http://www.yisutech.net:8080";
    /**
     * Sling 管理用户
     */
    public static String SLING_USER_PWD = "admin:admin";

    /**
     * jsonp回调函数名称
     */
    public static final String CALLBACK_FUNCTION = "callback";
    /**
     * uri
     */
    public static final String REQUEST_URI = "request_uri";

    static {
        try {
            PropertiesUtil propertiesUtil = new PropertiesUtil("cms-conf");
            SLING_SERVICE_URL = propertiesUtil.get("cms.sling.url");
            System.out.print(SLING_SERVICE_URL);

        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
