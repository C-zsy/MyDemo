package com.chinasoft.demo.pojo;

public class Owner {
    private int ownerID;

    private String ownerName;
    private int ownerSex;
    private String ownerNative;
    private String ownerPhone;
    private String ownerIden;
    private String ownerDen;
    private int roomId;
    private int roleId;
    private int ownerDelete;

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public int getOwnerSex() {
        return ownerSex;
    }

    public void setOwnerSex(int ownerSex) {
        this.ownerSex = ownerSex;
    }

    public String getOwnerNative() {
        return ownerNative;
    }

    public void setOwnerNative(String ownerNative) {
        this.ownerNative = ownerNative;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public String getOwnerIden() {
        return ownerIden;
    }

    public void setOwnerIden(String ownerIden) {
        this.ownerIden = ownerIden;
    }

    public String getOwnerDen() {
        return ownerDen;
    }

    public void setOwnerDen(String ownerDen) {
        this.ownerDen = ownerDen;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getOwnerDelete() {
        return ownerDelete;
    }

    public void setOwnerDelete(int ownerDelete) {
        this.ownerDelete = ownerDelete;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "ownerID=" + ownerID +
                ", ownerName='" + ownerName + '\'' +
                ", ownerSex=" + ownerSex +
                ", ownerNative='" + ownerNative + '\'' +
                ", ownerPhone='" + ownerPhone + '\'' +
                ", ownerIden='" + ownerIden + '\'' +
                ", ownerDen='" + ownerDen + '\'' +
                ", roomId=" + roomId +
                ", roleId=" + roleId +
                ", ownerDelete=" + ownerDelete +
                '}';
    }
}
