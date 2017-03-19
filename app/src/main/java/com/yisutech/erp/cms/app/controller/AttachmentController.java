package com.yisutech.erp.cms.app.controller;

import com.yishtech.erp.cms.biz.common.DateUtil;
import com.yishtech.erp.cms.biz.sling.HttpClientService;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * Created by guangzhong.wgz on 17/3/12.
 */
@Controller
@RequestMapping("/DocServer/repository/file")
public class AttachmentController {

    @Resource
    private HttpClientService httpClientService;

    @ResponseBody
    @RequestMapping(value = "cache", method = RequestMethod.POST)
    public String upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, ModelMap model) {
        String path = request.getSession().getServletContext().getRealPath("upload") + File.separator + DateUtil.formatYYYYMMDD(DateUtil.getNowTime());
        String fileName = System.currentTimeMillis() + "-DOC";
        String contentType = file.getContentType();
        Long fileSize = file.getSize();
        File targetFile = new File(path, fileName);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        //保存
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 上传附件
        String module = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><root>" +
                "<file mediatype=\"text/html\" file-name=\"${fileName}\" fileSize=\"${fileSize}\"></file>" +
                "</root>";
        module = module.replace("${fileName}", fileName).replace("${fileSize}", String.valueOf(fileSize));
        return module.toString();
    }

    @ResponseBody
    @RequestMapping(value = "commit", method = RequestMethod.POST)
    public String commit() {

        // 提交内容
        String uploadXml = "<data>" +
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

        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<root>" +
                "   <item>" +
                "       <doc-id>C76A414580500001D1EE5B8014FA6710</doc-id>" +
                "       <file-id>1-defaultDocNameSpace</file-id>" +
                "       <doc-version-id>1</doc-version-id>" +
                "   </item>" +
                "   <flag>true</flag>" +
                "   <message>commit fileCache success</message>" +
                "</root>";
        String docId = "";
        String fileId = "";
        String docVersionId = "";
        String flag = "";
        String message = "";
        return xml;
    }

    @ResponseBody
    @RequestMapping(value = "commit2", method = RequestMethod.POST)
    public String commit2() {
        String uploadXml = "<data>" +
                "   <item>" +
                "       <operation-type>flagCommit</operation-type>" +
                "       <kind>text/html</kind>" +
                "       <file-id>1-defaultDocNameSpace</file-id>" +
                "       <cache-name>1-DOC</cache-name>" +
                "   </item>" +
                "</data>";

        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<root>" +
                "   <flag>true</flag>" +
                "   <message>commit fileCache success</message>" +
                "</root>";
        String flag = "";
        String message = "";
        return xml;
    }


}