package com.yisutech.erp.cms.core.servcie.dataobject;

import java.io.File;
import java.io.Serializable;

/**
 * Created by guangzhong.wgz on 17/3/9.
 */
public class Document implements Serializable {
    private static final long serialVersionUID = 4022418850062225348L;
    /**
     * 标题
     */
    String title;
    /**
     * 路径
     */
    String path;
    /**
     * 摘要
     */
    String summary;
    /**
     * 文件
     */
    File file;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
