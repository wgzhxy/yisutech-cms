package com.yisutech.erp.cms.biz.common;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Map;

/**
 * Created by guangzhong.wgz on 17/3/19.
 */
public class Dom4jTools {

    private static Logger LOG = LoggerFactory.getLogger(Dom4jTools.class);

    public static Document getDocument(String xml) {
        try {
            if (StringUtils.isBlank(xml)) {
                return null;
            }
            SAXReader reader = new SAXReader();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xml.getBytes(CmsConstant.UTF_8));
            return reader.read(byteArrayInputStream);
        } catch (Throwable e) {
            LOG.error("Dom4jTools.getDocument", e);
        }
        return null;
    }

    public static Map<String, Object> getDocumentValues(String xml, String path) {
        Map<String, Object> retMap = Maps.newHashMap();
        List<Node> root = getDocument(xml).selectNodes(path);
        if (root != null && root.size() > 0) {
            for (Node node : root) {
                List<Element> contentList = node.getDocument().getRootElement().elements();
                for (Element obj : contentList) {
                    List<Element> elements = obj.elements();
                    for (Element element : elements) {
                        retMap.put(element.getName(), element.getText());
                    }
                }
            }
        }
        return retMap;
    }

}
