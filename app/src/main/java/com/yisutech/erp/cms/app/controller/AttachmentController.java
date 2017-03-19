package com.yisutech.erp.cms.app.controller;

import com.google.common.collect.Maps;
import com.yishtech.erp.cms.biz.common.DateUtil;
import com.yishtech.erp.cms.biz.common.Dom4jTools;
import com.yishtech.erp.cms.biz.sling.HttpClientService;
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
import java.util.Map;

/**
 * Created by guangzhong.wgz on 17/3/12.
 */
@Controller
@RequestMapping("/DocServer/repository/file/cache")
public class AttachmentController {

    @Resource
    private HttpClientService httpClientService;

    @ResponseBody
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestParam(value = "Filedata", required = false) MultipartFile file,
                         @RequestParam(value = "filename", required = false) String filename, HttpServletRequest request, ModelMap model) {
        // 上传附件
        String module = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><root>" +
                "<file mediatype=\"${contentType}\" file-name=\"${fileName}\" fileSize=\"${fileSize}\"></file>" +
                "</root>";
        if (file != null) {
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
            module = module.replace("${contentType}", contentType).replace("${fileName}", fileName).replace("${fileSize}", String.valueOf(fileSize));
        } else {
            module = module.replace("${contentType}", "").replace("${fileName}", "").replace("${fileSize}", String.valueOf(0));
        }
        return module.toString();
    }

    @ResponseBody
    @RequestMapping(value = "/commit", method = RequestMethod.POST)
    public String commit(@RequestParam String attachment, HttpServletRequest request) {
        // 解析xml文件内容
        Map<String, Object> attachementInfo = Dom4jTools.getDocumentValues(attachment, "//data/item");
        String modelXml = "";
        if (attachementInfo.get("operation-type").equals("new")) {
            // 保存文件到sling, 生成file-id, doc-version-id返回
            String path = request.getSession().getServletContext().getRealPath("upload") + File.separator + DateUtil.formatYYYYMMDD(DateUtil.getNowTime());
            String fileName = (String) attachementInfo.get("cache-name");

            Map<String, File> upFiles = Maps.newHashMap();
            upFiles.put("content", new File(path + File.separator + fileName));

            String resource = attachementInfo.get("doc-path") + File.separator + "last";
            httpClientService.postRequest(resource, attachementInfo);
            // 提交内容
            String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                    "<root>" +
                    "   <item>" +
                    "       <doc-id>${doc-id}</doc-id>" +
                    "       <file-id>${file-id}</file-id>" +
                    "       <doc-version-id>${doc-version-id}</doc-version-id>" +
                    "   </item>" +
                    "   <flag>true</flag>" +
                    "   <message>commit fileCache success</message>" +
                    "</root>";
            modelXml = xml.replace("${doc-id}", String.valueOf(attachementInfo.get("doc-id")))
                    .replace("${file-id}", "")
                    .replace("${doc-version-id}", "1");
        } else if (attachementInfo.get("operation-type").equals("flagCommit")) {
            modelXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                    "<root>" +
                    "   <flag>true</flag>" +
                    "   <message>commit fileCache success</message>" +
                    "</root>";
        }
        return modelXml;
    }
}
