package com.yisutech.erp.cms.biz.document.dataobject;

import java.io.Serializable;

/**
 * Created by guangzhong.wgz on 17/4/15.
 */
public class FileNode implements Serializable {

    private static final long serialVersionUID = -4867280765657072758L;
    /**
     * 文件编号
     */
    private String sFileId;
    /**
     * 最后修改时间
     */
    private String lastModified;
    /**
     * 最后修改人
     */
    private String lastModifier;
    /**
     * 文件名称
     */
    private String name;
    /**
     * mimeType
     */
    private String mimeType;
    /**
     * 更新次数
     */
    private Integer updateCount;
    /**
     * 最新版本号
     */
    private String last;
    /**
     * live
     */
    private String live;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 创建时间
     */
    private String createOn;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getsFileId() {
        return sFileId;
    }

    public void setsFileId(String sFileId) {
        this.sFileId = sFileId;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public String getLastModifier() {
        return lastModifier;
    }

    public void setLastModifier(String lastModifier) {
        this.lastModifier = lastModifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public Integer getUpdateCount() {
        return updateCount;
    }

    public void setUpdateCount(Integer updateCount) {
        this.updateCount = updateCount;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getLive() {
        return live;
    }

    public void setLive(String live) {
        this.live = live;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateOn() {
        return createOn;
    }

    public void setCreateOn(String createOn) {
        this.createOn = createOn;
    }
}
