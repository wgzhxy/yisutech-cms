package com.yisutech.erp.cms.core;

import com.oracle.tools.packager.Log;
import org.apache.jackrabbit.commons.JcrUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.GuestCredentials;
import javax.jcr.Repository;
import javax.jcr.Session;

/**
 * First hop example. Logs in to a content repository and prints a
 * status message.
 */
public class TestFirstHop {

    private static Logger logger = LoggerFactory.getLogger(TestFirstHop.class);

    @Test
    public void testGetJcrSessionUsrInfo() throws Exception {
        Repository repository = JcrUtils.getRepository();
        Session session = repository.login(new GuestCredentials());
        try {
            String user = session.getUserID();
            String name = repository.getDescriptor(Repository.REP_NAME_DESC);
            logger.info("Logged in as {} to a {} repository.", user, name);
        } finally {
            session.logout();
        }
    }
}