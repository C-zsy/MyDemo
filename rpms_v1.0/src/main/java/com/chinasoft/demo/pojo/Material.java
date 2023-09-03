package com.chinasoft.demo.pojo;

public class Material {
    private int typeId;
    private String typeName;
    private int typeDelete;

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getTypeDelete() {
        return typeDelete;
    }

    public void setTypeDelete(int typeDelete) {
        this.typeDelete = typeDelete;
    }

    @Override
    public String toString() {
        return "Material{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                ", typeDelete=" + typeDelete +
                '}';
    }
}
