package com.yisutech.erp.cms.framework.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author guangzhong.wgz
 */
public final class ThreadLocalUtil {

    public static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal() {
        protected Map<String, Object> initialValue() {
            return new HashMap(4);
        }
    };

    public ThreadLocalUtil() {
    }


    public static void set(String key, Object value) {
        Map map = (Map) threadLocal.get();
        map.put(key, value);
    }

    public static Object get(String key) {
        Map map = (Map) threadLocal.get();
        return map.get(key);
    }

    public static void set(Map<String, Object> keyValueMap) {
        Map map = (Map) threadLocal.get();
        map.putAll(keyValueMap);
    }

    public static void remove() {
        threadLocal.remove();
    }

}