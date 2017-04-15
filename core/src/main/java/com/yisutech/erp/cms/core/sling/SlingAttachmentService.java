package com.yisutech.erp.cms.core.sling;

import com.yisutech.erp.cms.core.sling.dataobject.SlingEnum;

import java.util.Map;

/**
 * sling 增删改查
 * <p>
 * Created by guangzhong.wgz on 17/2/20.
 *
 * @author guangzhong.wgz
 */
public interface SlingAttachmentService {

    /**
     * 查看文档
     *
     * @param partType     文件部分信息
     * @param resourcePath 资源路径
     * @param version      版本
     */
    public String viewfileInfo(SlingEnum.PartType partType, String resourcePath, String version);

    /**
     * 保存文档
     *
     * @param partType     文件部分信息
     * @param resourcePath 资源路径
     * @param version      版本
     * @param properties   文件相关属性信息
     *                     <?xml version="1.0" encoding="UTF-8"?>
     *                     <root>
     *                     <file mediatype="text/html" file-name="1-DOC" fileSize="5898"></file>
     *                     </root>
     */
    public String savefileInfo(SlingEnum.PartType partType, String resourcePath, String version,
                               Map<String, Object> properties);

    /**
     * @param resourcePath 资源存府url
     * @param properties   属性计算
     *                     <?xml version="1.0" encoding="UTF-8"?>
     *                     <root><item>
     *                     <doc-id>C76A414580500001D1EE5B8014FA6710</doc-id>
     *                     <file-id>1-defaultDocNameSpace</file-id>
     *                     <doc-version-id>1</doc-version-id>
     *                     </item>
     *                     <flag>true</flag>
     *                     <message>commit fileCache success</message></root>
     *                     <p>
     *                     <?xml version="1.0" encoding="UTF-8"?>
     *                     <root>
     *                     <flag>true</flag>
     *                     <message>commit fileCache success</message>
     *                     </root>
     */
    public String commitCacheFile(String resourcePath, Map<String, Object> properties);

}
