package com.yisutech.erp.cms.app.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yisutech.erp.cms.core.sling.HttpClientService;
import com.yisutech.erp.cms.framework.http.SlingResponse;
import com.yisutech.erp.cms.framework.utils.FwConstant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping(value = "/fileinfo/{defaultDocNameSpace}/last")
    public void viewLast(@PathVariable String defaultDocNameSpace, HttpServletResponse response) {
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
                "       <ns:customField name=\"sLastWriterName\" value=\"${person-name}\"/>" +
                "       <ns:customField name=\"sKeywords\" value=\"\"/>" +
                "       <ns:customField name=\"sDescription\" value=\"\"/>" +
                "       <ns:customField name=\"sDocPath\" value=\"${doc-path}\"/>" +
                "       <ns:customField name=\"sClassification\" value=\"\"/>" +
                "       <ns:customField name=\"sLastWriterDeptName\" value=\"\"/>" +
                "       <ns:customField name=\"sFinishTime\" value=\"\"/>" +
                "       <ns:customField name=\"sCreatorFID\" value=\"${person}\"/>" +
                "       <ns:customField name=\"sDocSerialNumber\" value=\"\"/>" +
                "       <ns:customField name=\"sEditorFID\" value=\"\"/>" +
                "       <ns:customField name=\"VERSION\" value=\"0\"/>" +
                "       <ns:customField name=\"sLastWriterFID\" value=\"${person}\"/>" +
                "       <ns:customField name=\"sEditorDeptName\" value=\"\"/>" +
                "       <ns:customField name=\"sFlag\" value=\"1\"/>" +
                "       <ns:customField name=\"sCreatorDeptName\" value=\"\"/>" +
                "       <ns:customField name=\"sParentID\" value=\"${parent-id}\"/>" +
                "       <ns:customField name=\"sCreatorName\" value=\"${person-name}\"/>" +
                "       <ns:customField name=\"sEditorName\" value=\"\"/>" +
                "       <ns:customField name=\"sDocId\" value=\"${doc-id}\"/>" +
                "       <ns:customField name=\"sDocDisplayPath\" value=\"${doc-display-path}\"/>" +
                "   </ns:customFields>" +
                "   <ns:lockInfo hasLock=\"false\"/>" +
                "   <ns:collectionIds/><ns:fields/>" +
                "   <ns:parts>" +
                "         <ns:part typeId=\"1\" size=\"5898\" mimeType=\"text/html\" dataChangedInVersion=\"1\"/>" +
                "   </ns:parts>" +
                "   <ns:links/>" +
                "</ns:document>";
        String retContent = "";
        try {
            String resourcePath = File.separator + defaultDocNameSpace + File.separator + "last.json";
            SlingResponse slingResponse = httpClientService.getRequest(resourcePath);
            if (slingResponse.getStatusCode() == 200 && StringUtils.isNotBlank(slingResponse.getContent())) {
                JSONObject json = JSON.parseObject(slingResponse.getContent());
                lastContent = lastContent.replace("${person-name}", json.getString("person-name"))
                        .replace("${doc-path}", json.getString("doc-path"))
                        .replace("${person}", json.getString("person"))
                        .replace("${parent-id}", json.getString("parent-id"))
                        .replace("${doc-id}", json.getString("doc-id"))
                        .replace("${doc-display-path}", json.getString("doc-display-path"));
            } else {
                retContent = slingResponse.getContent();
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        try {
            response.setCharacterEncoding(FwConstant.UTF_8);
            response.setContentType("application/xml");
            response.getOutputStream().write(lastContent.getBytes(FwConstant.UTF_8));
            response.getOutputStream().flush();
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            try {
                response.getOutputStream().close();
            } catch (Throwable e) {
            }
        }
    }

    @RequestMapping(value = "/file/view/{defaultDocNameSpace}/last/content")
    public String viewLastContent(@PathVariable String defaultDocNameSpace, HttpServletResponse response) {
        // 附件
        String fileName = "";
        String resourcePath = File.separator + defaultDocNameSpace + File.separator + "last.json";
        SlingResponse slingResponse = httpClientService.getRequest(resourcePath);
        if (slingResponse.getStatusCode() == 200 && StringUtils.isNotBlank(slingResponse.getContent())) {
            JSONObject json = JSON.parseObject(slingResponse.getContent());
            fileName = json.getString("doc-name");
        } else {
            try {
                response.setCharacterEncoding(FwConstant.UTF_8);
                response.setContentType("application/xml");
                response.getOutputStream().write(slingResponse.getContent().getBytes(FwConstant.UTF_8));
                response.getOutputStream().flush();
            } catch (Throwable e) {
                e.printStackTrace();
            } finally {
                try {
                    response.getOutputStream().close();
                } catch (Throwable e) {
                }
            }
        }
        String uri = FwConstant.SLING_SERVICE_URL + File.separator +
                defaultDocNameSpace + File.separator +
                "last" + File.separator + fileName;
        return "redirect:" + uri;
    }

}
