package com.yisutech.erp.cms.app.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yishtech.erp.cms.biz.sling.HttpClientService;
import com.yisutech.erp.cms.framework.http.SlingResponse;
import com.yisutech.erp.cms.framework.utils.FwConstant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * Created by guangzhong.wgz on 17/3/15.
 */
@Controller
@RequestMapping("/DocServer/repository")
public class ViewDocController {

    @Resource
    private HttpClientService httpClientService;

    @ResponseBody
    @RequestMapping(value = "/fileinfo/{defaultDocNameSpace}/last")
    public String viewLast(@PathVariable String defaultDocNameSpace) {
        // 上传附件
        // 返回文档内容
        String lastContent = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<ns:document id=\"1-defaultDocNameSpace\" " +
                "    lastModified=\"2017-02-14T14:58:41.000+08:00\" " +
                "    lastModifier=\"2\" created=\"2017-02-14T14:58:41.000+08:00\" " +
                "    owner=\"2\" " +
                "    private=\"false\" " +
                "    updateCount=\"1\" " +
                "    referenceLanguageId=\"-1\" " +
                "    variantLastModified=\"2017-02-14T14:58:42.000+08:00\" " +
                "    variantLastModifier=\"2\" " +
                "    liveVersionId=\"1\" " +
                "    branchId=\"1\" " +
                "    languageId=\"1\" " +
                "    typeId=\"2\" " +
                "    lastVersionId=\"1\" " +
                "    retired=\"false\" " +
                "    newVersionState=\"publish\" " +
                "    newChangeType=\"major\" " +
                "    variantUpdateCount=\"2\" " +
                "    createdFromBranchId=\"-1\" " +
                "    createdFromLanguageId=\"-1\" " +
                "    createdFromVersionId=\"-1\" " +
                "    documentTypeChecksEnabled=\"true\" " +
                "    lastMajorChangeVersionId=\"1\" " +
                "    liveMajorChangeVersionId=\"1\" " +
                "    dataVersionId=\"-1\" " +
                "    name=\"jcr-content.htm\" " +
                "    validateOnSave=\"true\" xmlns:ns=\"http://outerx.org/daisy/1.0\">" +
                "   <ns:newChangeComment xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>" +
                "   <ns:customFields>" +
                "       <ns:customField name=\"sLastWriterName\" value=\"system\"/>" +
                "       <ns:customField name=\"sKeywords\" value=\"\"/>" +
                "       <ns:customField name=\"sDescription\" value=\"\"/>" +
                "       <ns:customField name=\"sDocPath\" value=\"/defaultDocNameSpace/9d0f322f-a9a6-4576-b539-e734431ab509\"/>" +
                "       <ns:customField name=\"sClassification\" value=\"\"/>" +
                "       <ns:customField name=\"sLastWriterDeptName\" value=\"\"/>" +
                "       <ns:customField name=\"sFinishTime\" value=\"\"/>" +
                "       <ns:customField name=\"sCreatorFID\" value=\"/ORG01.ogn/PSN01@ORG01.psm\"/>" +
                "       <ns:customField name=\"sDocSerialNumber\" value=\"\"/>" +
                "       <ns:customField name=\"sEditorFID\" value=\"\"/>" +
                "       <ns:customField name=\"VERSION\" value=\"0\"/>" +
                "       <ns:customField name=\"sLastWriterFID\" value=\"/ORG01.ogn/PSN01@ORG01.psm\"/>" +
                "       <ns:customField name=\"sEditorDeptName\" value=\"\"/>" +
                "       <ns:customField name=\"sFlag\" value=\"1\"/>" +
                "       <ns:customField name=\"sCreatorDeptName\" value=\"\"/>" +
                "       <ns:customField name=\"sParentID\" value=\"9d0f322f-a9a6-4576-b539-e734431ab509\"/>" +
                "       <ns:customField name=\"sCreatorName\" value=\"system\"/>" +
                "       <ns:customField name=\"sEditorName\" value=\"\"/>" +
                "       <ns:customField name=\"sDocId\" value=\"C76A414580500001D1EE5B8014FA6710\"/>" +
                "       <ns:customField name=\"sDocDisplayPath\" value=\"/文档中心/attachmentDialog类型\"/>" +
                "   </ns:customFields>" +
                "   <ns:lockInfo hasLock=\"false\"/>" +
                "   <ns:collectionIds/><ns:fields/>" +
                "   <ns:parts>" +
                "         <ns:part typeId=\"1\" size=\"5898\" mimeType=\"text/html\" dataChangedInVersion=\"1\"/>" +
                "   </ns:parts>" +
                "   <ns:links/>" +
                "</ns:document>";
        try {
            String resourcePath = File.separator + defaultDocNameSpace + File.separator + "last.json";
            SlingResponse slingResponse = httpClientService.getRequest(resourcePath);
            //System.out: {"jcr:primaryType":"nt:unstructured",
            // "doc-version-id":"null",
            // "operation-type":"new",
            // "doc-id":"C76A414580500001D1EE5B8014FA6710",
            // "doc-display-path":"%2F%E6%96%87%E6%A1%A3%E4%B8%AD%E5%BF%83%2FattachmentDialog%E7%B1%BB%E5%9E%8B",
            // "person":"%2FORG01.ogn%2FPSN01%40ORG01.psm",
            // "person-name":"system",
            // "cache-name":"+1490022725743-DOC",
            // "kind":"text%2Fhtml",
            // "size":"5898.0",
            // "version":"0",
            // "doc-name":"%E5%A4%A9%E7%8C%AB%E6%95%B0%E6%8D%AE%E9%A9%B1%E5%8A%A8%E4%B9%8BABTest.pptx",
            // "doc-path":"%2FdefaultDocNameSpace%2F9d0f322f-a9a6-4576-b539-e734431ab506",
            // "doc-type":"attachment",
            // "parent-id":"9d0f322f-a9a6-4576-b539-e734431ab506"}
            System.out.println(slingResponse.getContent());
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return lastContent;

    }

    @RequestMapping(value = "/file/view/{defaultDocNameSpace}/last/content")
    public String viewLastContent(@PathVariable String defaultDocNameSpace, HttpServletResponse response) {
        // 附件
        String fileName = "";
        String resourcePath = File.separator + defaultDocNameSpace + File.separator + "last.json";
        SlingResponse slingResponse = httpClientService.getRequest(resourcePath);
        if (StringUtils.isNotBlank(slingResponse.getContent())) {
            JSONObject json = JSON.parseObject(slingResponse.getContent());
            fileName = json.getString("doc-name");
        }
        String uri = FwConstant.SLING_SERVICE_URL + File.separator +
                defaultDocNameSpace + File.separator +
                "last" + File.separator + fileName;
        return "redirect:" + uri;
    }

}
