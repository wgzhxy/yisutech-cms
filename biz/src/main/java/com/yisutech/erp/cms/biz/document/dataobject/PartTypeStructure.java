package com.yisutech.erp.cms.biz.document.dataobject;

/**
 * Created by guangzhong.wgz on 17/4/15.
 */
public class PartTypeStructure {

    String id;
    String name;
    String sFiled;
    Integer updateCount;
    String lastModified;
    String lastmodifier;
    String deprecated;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getsFiled() {
        return sFiled;
    }

    public void setsFiled(String sFiled) {
        this.sFiled = sFiled;
    }

    public Integer getUpdateCount() {
        return updateCount;
    }

    public void setUpdateCount(Integer updateCount) {
        this.updateCount = updateCount;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public String getLastmodifier() {
        return lastmodifier;
    }

    public void setLastmodifier(String lastmodifier) {
        this.lastmodifier = lastmodifier;
    }

    public String getDeprecated() {
        return deprecated;
    }

    public void setDeprecated(String deprecated) {
        this.deprecated = deprecated;
    }
}
