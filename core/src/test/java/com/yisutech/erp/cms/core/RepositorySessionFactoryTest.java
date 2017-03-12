package com.yisutech.erp.cms.core;

import org.apache.jackrabbit.value.BinaryValue;
import org.junit.Test;
import org.springframework.util.Assert;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.Session;
import java.io.FileInputStream;

/**
 * Created by guangzhong.wgz on 17/3/9.
 */
public class RepositorySessionFactoryTest {

    @Test
    public void testSaveDocument() {
        Session session = RepositorySessionFactory.openSession();
        Assert.notNull(session);
        try {
            Node node = session.getRootNode().addNode("test");
            String fileUrl = "/Users/guangzhong.wgz/antWorkSpace/yisutech-cms/core/derby.log";
            BinaryValue binaryValue = new BinaryValue(new FileInputStream(fileUrl));
            node.setProperty("derby.log", binaryValue);
            node.setProperty("title", "test001");

            session.save();
            session.logout();

        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRemoveDocument() {
        Session session = RepositorySessionFactory.openSession();
        Assert.notNull(session);
        try {
            Node node = session.getRootNode().getNode("test");
            node.remove();
            session.save();
            session.logout();

        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdateDocument() {

        Session session = RepositorySessionFactory.openSession();
        Assert.notNull(session);
        try {
            Node node = session.getRootNode().getNode("test");
            node.remove();
            session.save();

            node = session.getRootNode().addNode("test");
            String fileUrl = "/Users/guangzhong.wgz/antWorkSpace/yisutech-cms/core/derby.log";
            BinaryValue binaryValue = new BinaryValue(new FileInputStream(fileUrl));
            node.setProperty("derby.log", binaryValue);
            node.setProperty("title", "test001fdsfdsfsdfdsfdsfds");
            session.save();
            session.logout();

        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetDocument() {
        Session session = RepositorySessionFactory.openSession();
        Assert.notNull(session);
        try {
            Node node = session.getRootNode().getNode("test");
            System.out.println(node.getProperty("title").getString());
            System.out.println();
            session.logout();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    @Test
    public void queryAllDocument() {
        Session session = RepositorySessionFactory.openSession();
        Assert.notNull(session);
        try {
            NodeIterator nodeIterator = session.getRootNode().getNodes();
            while (nodeIterator.hasNext()) {
                Node nextNode = nodeIterator.nextNode();
                if(nextNode.getPath().contains("test")) {
                    System.out.println(nextNode.getProperty("title").getString());
                }
            }
            session.logout();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
