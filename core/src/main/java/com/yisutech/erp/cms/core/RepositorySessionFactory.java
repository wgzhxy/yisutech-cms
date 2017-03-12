package com.yisutech.erp.cms.core;

import com.yisutech.erp.cms.framework.utils.PropertiesUtil;
import org.apache.commons.lang3.StringUtils;

import javax.jcr.Session;
import javax.jcr.SimpleCredentials;

/**
 * Created by guangzhong.wgz on 17/3/9.
 */
public class RepositorySessionFactory {

    /**
     * 文档存储库工厂
     */
    private static RepositoryFactory repositoryFactory = null;
    /**
     * 用户名
     */
    private static String userName = "";
    /**
     * 密码
     */
    private static String pwd = "";

    static {
        try {
            PropertiesUtil propertiesUtil = new PropertiesUtil("repository");
            repositoryFactory = new RepositoryFactory(propertiesUtil.get("repository.uri"));
            userName = propertiesUtil.get("repository.userName");
            pwd = propertiesUtil.get("repository.pwd");
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取JCR库连接Session
     *
     * @param userName 用户名
     * @param password 密码
     * @return
     */
    public static Session openSession(String userName, String password) {
        try {
            if (StringUtils.isNotBlank(userName)) {
                RepositorySessionFactory.userName = userName;
            }
            if (StringUtils.isBlank(password)) {
                RepositorySessionFactory.pwd = password;
            }
            return repositoryFactory.instance().login(new SimpleCredentials(RepositorySessionFactory.userName,
                    RepositorySessionFactory.pwd.toCharArray()));
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取JCR库连接Session
     *
     * @return
     */
    public static Session openSession() {
        try {
            return repositoryFactory.instance().login(new SimpleCredentials(RepositorySessionFactory.userName,
                    RepositorySessionFactory.pwd.toCharArray()));
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

}
