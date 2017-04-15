package com.yisutech.erp.cms.biz.document.dataobject;

/**
 * Created by guangzhong.wgz on 17/4/15.
 */
public class Version {

    String variantId;
    String sDocId;
    String sParentID;
    String sDocPath;
    String sDocDisplayPath;
    String sCreatorFID;
    String sCreatorName;
    String sCreatorDeptName;
    String sEditorFID;
    String sEditorName;
    String sEditorDeptName;
    String sLastWriterFID;
    String sLastWriterName;
    String sLastWriterDeptName;
    String sDescription;
    String VERSION;
    String fileSize;
    String sClassification;
    String sKeywords;
    String sDocSerialNumber;
    String sFinishTime;
    /**
     * 1：正常，
     * 0：逻辑删除，
     * -2：草稿
     */
    String sFlag;

    public String getVariantId() {
        return variantId;
    }

    public void setVariantId(String variantId) {
        this.variantId = variantId;
    }

    public String getsDocId() {
        return sDocId;
    }

    public void setsDocId(String sDocId) {
        this.sDocId = sDocId;
    }

    public String getsParentID() {
        return sParentID;
    }

    public void setsParentID(String sParentID) {
        this.sParentID = sParentID;
    }

    public String getsDocPath() {
        return sDocPath;
    }

    public void setsDocPath(String sDocPath) {
        this.sDocPath = sDocPath;
    }

    public String getsDocDisplayPath() {
        return sDocDisplayPath;
    }

    public void setsDocDisplayPath(String sDocDisplayPath) {
        this.sDocDisplayPath = sDocDisplayPath;
    }

    public String getsCreatorFID() {
        return sCreatorFID;
    }

    public void setsCreatorFID(String sCreatorFID) {
        this.sCreatorFID = sCreatorFID;
    }

    public String getsCreatorName() {
        return sCreatorName;
    }

    public void setsCreatorName(String sCreatorName) {
        this.sCreatorName = sCreatorName;
    }

    public String getsCreatorDeptName() {
        return sCreatorDeptName;
    }

    public void setsCreatorDeptName(String sCreatorDeptName) {
        this.sCreatorDeptName = sCreatorDeptName;
    }

    public String getsEditorFID() {
        return sEditorFID;
    }

    public void setsEditorFID(String sEditorFID) {
        this.sEditorFID = sEditorFID;
    }

    public String getsEditorName() {
        return sEditorName;
    }

    public void setsEditorName(String sEditorName) {
        this.sEditorName = sEditorName;
    }

    public String getsEditorDeptName() {
        return sEditorDeptName;
    }

    public void setsEditorDeptName(String sEditorDeptName) {
        this.sEditorDeptName = sEditorDeptName;
    }

    public String getsLastWriterFID() {
        return sLastWriterFID;
    }

    public void setsLastWriterFID(String sLastWriterFID) {
        this.sLastWriterFID = sLastWriterFID;
    }

    public String getsLastWriterName() {
        return sLastWriterName;
    }

    public void setsLastWriterName(String sLastWriterName) {
        this.sLastWriterName = sLastWriterName;
    }

    public String getsLastWriterDeptName() {
        return sLastWriterDeptName;
    }

    public void setsLastWriterDeptName(String sLastWriterDeptName) {
        this.sLastWriterDeptName = sLastWriterDeptName;
    }

    public String getsDescription() {
        return sDescription;
    }

    public void setsDescription(String sDescription) {
        this.sDescription = sDescription;
    }

    public String getVERSION() {
        return VERSION;
    }

    public void setVERSION(String VERSION) {
        this.VERSION = VERSION;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getsClassification() {
        return sClassification;
    }

    public void setsClassification(String sClassification) {
        this.sClassification = sClassification;
    }

    public String getsKeywords() {
        return sKeywords;
    }

    public void setsKeywords(String sKeywords) {
        this.sKeywords = sKeywords;
    }

    public String getsDocSerialNumber() {
        return sDocSerialNumber;
    }

    public void setsDocSerialNumber(String sDocSerialNumber) {
        this.sDocSerialNumber = sDocSerialNumber;
    }

    public String getsFinishTime() {
        return sFinishTime;
    }

    public void setsFinishTime(String sFinishTime) {
        this.sFinishTime = sFinishTime;
    }

    public String getsFlag() {
        return sFlag;
    }

    public void setsFlag(String sFlag) {
        this.sFlag = sFlag;
    }
}


