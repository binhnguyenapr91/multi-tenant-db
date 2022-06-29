package com.example.demo.entity;

import java.sql.Timestamp;

/**
 * @author: Binh Nguyen
 * Jun 1, 2022
 */

public class Adapter {
    String id;
    String adapterId;
    String adapterName;
    Timestamp createdTime;
    String createdBy;
    Timestamp modifiedTime;
    String modifiedBy;

    public Adapter(String id, String adapterId, String adapterName, Timestamp createdTime, String createdBy, Timestamp modifiedTime, String modifiedBy) {
        this.id = id;
        this.adapterId = adapterId;
        this.adapterName = adapterName;
        this.createdTime = createdTime;
        this.createdBy = createdBy;
        this.modifiedTime = modifiedTime;
        this.modifiedBy = modifiedBy;
    }

    public Adapter() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdapterId() {
        return adapterId;
    }

    public void setAdapterId(String adapterId) {
        this.adapterId = adapterId;
    }

    public String getAdapterName() {
        return adapterName;
    }

    public void setAdapterName(String adapterName) {
        this.adapterName = adapterName;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Timestamp modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Override
    public String toString() {
        return "Adapter{" +
                "id='" + id + '\'' +
                ", adapterId='" + adapterId + '\'' +
                ", adapterName='" + adapterName + '\'' +
                ", createdTime=" + createdTime +
                ", createdBy='" + createdBy + '\'' +
                ", modifiedTime=" + modifiedTime +
                ", modifiedBy='" + modifiedBy + '\'' +
                '}';
    }
}
