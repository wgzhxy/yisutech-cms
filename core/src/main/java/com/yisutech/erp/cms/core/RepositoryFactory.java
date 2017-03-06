package com.yisutech.erp.cms.core;

import org.apache.commons.lang3.StringUtils;
import org.apache.jackrabbit.commons.JcrUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Repository;
import javax.jcr.RepositoryException;

/**
 * Created by guangzhong.wgz on 17/3/5.
 */
public class RepositoryFactory {

    /**
     * 实例uri
     */
    private String repoUri = "";
    /**
     * Repository 实例列表
     */
    private static Repository repoInstances = null;

    private static Logger LOG = LoggerFactory.getLogger(RepositoryUtils.class);

    /**
     * 初始化实例
     *
     * @return
     */
    public Repository instance() {
        if (repoInstances == null) {
            synchronized (RepositoryFactory.class) {
                if (repoInstances == null) {
                    if (StringUtils.isNotBlank(repoUri)) {
                        repoInstances = initRepository(this.repoUri);
                    } else {
                        repoInstances = initLocalRepository();
                    }
                }
            }
        }
        return repoInstances;
    }

    public String getRepoUri() {
        return repoUri;
    }

    public void setRepoUri(String repoUri) {
        this.repoUri = repoUri;
    }

    /**
     * 初始化远程实例
     *
     * @param repoServerUri 远程Uri
     * @return
     */
    private Repository initRepository(String repoServerUri) {
        try {
            return JcrUtils.getRepository(repoServerUri);
        } catch (RepositoryException e) {
            LOG.error("initRepository error", e);
            throw new RuntimeException(e.getCause());
        }
    }

    /**
     * 初始化本地实例
     *
     * @return
     */
    private Repository initLocalRepository() {
        try {
            return JcrUtils.getRepository();
        } catch (RepositoryException e) {
            LOG.error("initLocalRepository error", e);
            throw new RuntimeException(e.getCause());
        }
    }
}
