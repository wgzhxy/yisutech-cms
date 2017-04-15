import com.yisutech.erp.cms.biz.common.Dom4jTools;
import org.dom4j.Document;
import org.dom4j.Element;
import org.junit.Test;
import org.springframework.util.Assert;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by guangzhong.wgz on 17/3/19.
 */
public class Dom4jToolsTest {

    private static String uploadXml = "<data>" +
            "   <item>" +
            "       <operation-type>new</operation-type>" +
            "       <process></process>" +
            "       <activity></activity>" +
            "       <person>/ORG01.ogn/PSN01@ORG01.psm</person>" +
            "       <person-name>system</person-name>" +
            "       <dept-name></dept-name>" +
            "       <bill-id></bill-id>" +
            "       <doc-id>C76A414580500001D1EE5B8014FA6710</doc-id>" +
            "       <version>0</version>" +
            "       <file-id></file-id>" +
            "       <doc-version-id>null</doc-version-id>" +
            "       <doc-name><![CDATA[jcr-content.htm]]></doc-name>" +
            "       <kind>text/html</kind>" +
            "       <size>5898.0</size>" +
            "       <parent-id>9d0f322f-a9a6-4576-b539-e734431ab509</parent-id>" +
            "       <doc-path>/defaultDocNameSpace/9d0f322f-a9a6-4576-b539-e734431ab509</doc-path>" +
            "       <doc-display-path>/文档中心/attachmentDialog类型</doc-display-path>" +
            "       <description></description>" +
            "       <classification></classification>" +
            "       <keywords></keywords>" +
            "       <finish-time></finish-time>" +
            "       <serial-number></serial-number>" +
            "       <doc-type>attachment</doc-type>" +
            "       <cache-name>1-DOC</cache-name>" +
            "       <revision-cache-name></revision-cache-name>" +
            "       <comment-file-content></comment-file-content>" +
            "       <link-id></link-id>" +
            "       <access-record-id></access-record-id>" +
            "   </item>" +
            "</data>";

    @Test
    public void testGetDocument() {
        Document document = Dom4jTools.getDocument(uploadXml);
        if (document != null) {
            Element root = document.getRootElement();
            for (Iterator i = root.elementIterator(); i.hasNext(); ) {
                Element element = (Element) i.next();
                System.out.println(element.getName() + " " + element.getStringValue());
            }
        }
    }

    @Test
    public void testGetDocumentValues() {
        Map<String, Object> values = Dom4jTools.getDocumentValues(uploadXml, "//data/item");
        Assert.notNull(values);
    }
}


