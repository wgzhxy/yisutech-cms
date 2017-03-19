package com.yisutech.erp.cms.app.controller;

import com.yishtech.erp.cms.biz.common.CmsConstant;
import com.yishtech.erp.cms.biz.sling.HttpClientService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

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
    public String view() {
        // 上传附件

        // 返回文档内容
        String lastContent = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
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
        return lastContent;
    }

    @RequestMapping(value = "/file/view/{defaultDocNameSpace}/last/content")
    public void viewContent(HttpServletResponse response) {
        // 附件
        String xml = "";
        int fileSize = 0;
        String contentType = "";
        response.setCharacterEncoding(CmsConstant.UTF_8);
        response.setContentLength(fileSize);
        response.setContentType(contentType);
        try {
            /*
            Byte[] contentByte = httpClientService.getRequest();
            response.getOutputStream().write();
            */
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

}
