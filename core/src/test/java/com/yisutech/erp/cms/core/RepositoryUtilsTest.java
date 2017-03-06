package com.yisutech.erp.cms.core;

import org.junit.Assert;
import org.junit.Test;

import javax.jcr.Repository;

/**
 * Created by guangzhong.wgz on 17/3/5.
 */
public class RepositoryUtilsTest {

    @Test
    public void getRepository() {
        try {
            RepositoryFactory repositoryFactory = new RepositoryFactory();
            repositoryFactory.setRepoUri("http://localhost:8080/rmi");
            Repository repo = repositoryFactory.instance();
            Assert.assertNotNull(repo);
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }
}