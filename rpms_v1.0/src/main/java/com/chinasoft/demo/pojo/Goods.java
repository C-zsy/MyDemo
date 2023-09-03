package com.chinasoft.demo.pojo;

import java.util.Date;

//物资信息pojo
public class Goods {
    private int materialId;
    private String materialName;
    private int materialCount;
    private float materialPrice;
    private int typeId;
    private String  materialDate;
    private String materialOutDate;
    private int materialStat;
    private int materialDelete;

    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public int getMaterialCount() {
        return materialCount;
    }

    public void setMaterialCount(int materialCount) {
        this.materialCount = materialCount;
    }

    public float getMaterialPrice() {
        return materialPrice;
    }

    public void setMaterialPrice(float materialPrice) {
        this.materialPrice = materialPrice;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getMaterialDate() {
        return materialDate;
    }

    public void setMaterialDate(String materialDate) {
        this.materialDate = materialDate;
    }

    public String getMaterialOutDate() {
        return materialOutDate;
    }

    public void setMaterialOutDate(String  materialOutDate) {
        this.materialOutDate = materialOutDate;
    }

    public int getMaterialStat() {
        return materialStat;
    }

    public void setMaterialStat(int materialStat) {
        this.materialStat = materialStat;
    }

    public int getMaterialDelete() {
        return materialDelete;
    }

    public void setMaterialDelete(int materialDelete) {
        this.materialDelete = materialDelete;
    }

    @Override
    public String toString() {
        return "goods{" +
                "materialId=" + materialId +
                ", materialName='" + materialName + '\'' +
                ", materialCount=" + materialCount +
                ", materialPrice=" + materialPrice +
                ", typeId=" + typeId +
                ", materialDate=" + materialDate +
                ", materialOutDate=" + materialOutDate +
                ", materialStat=" + materialStat +
                ", materialDelete=" + materialDelete +
                '}';
    }
}
