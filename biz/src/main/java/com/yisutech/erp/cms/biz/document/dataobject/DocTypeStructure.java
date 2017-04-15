package com.yisutech.erp.cms.biz.document.dataobject;

import java.util.List;

/**
 * Created by guangzhong.wgz on 17/4/15.
 */
public class DocTypeStructure {

    String id;
    String lastModified;
    String lastModifier;
    String name;
    Long updateCount;
    String partTypeUses;
    String deprecated;
    List<PartType> parType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Long getUpdateCount() {
        return updateCount;
    }

    public void setUpdateCount(Long updateCount) {
        this.updateCount = updateCount;
    }

    public String getPartTypeUses() {
        return partTypeUses;
    }

    public void setPartTypeUses(String partTypeUses) {
        this.partTypeUses = partTypeUses;
    }

    public String getDeprecated() {
        return deprecated;
    }

    public void setDeprecated(String deprecated) {
        this.deprecated = deprecated;
    }

    public List<PartType> getParType() {
        return parType;
    }

    public void setParType(List<PartType> parType) {
        this.parType = parType;
    }

    class PartType {
        String partTypeId;
        String required;
        String editable;

        public String getPartTypeId() {
            return partTypeId;
        }

        public void setPartTypeId(String partTypeId) {
            this.partTypeId = partTypeId;
        }

        public String getRequired() {
            return required;
        }

        public void setRequired(String required) {
            this.required = required;
        }

        public String getEditable() {
            return editable;
        }

        public void setEditable(String editable) {
            this.editable = editable;
        }
    }
}
