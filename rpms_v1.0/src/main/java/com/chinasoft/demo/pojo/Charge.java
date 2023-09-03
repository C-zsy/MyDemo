package com.chinasoft.demo.pojo;

public class Charge {
    private int chargeId;
    private String chargeName;
    private float chargeUnit;

    public int getChargeId() {
        return chargeId;
    }

    public void setChargeId(int chargeId) {
        this.chargeId = chargeId;
    }

    public String getChargeName() {
        return chargeName;
    }

    public void setChargeName(String chargeName) {
        this.chargeName = chargeName;
    }

    public float getChargeUnit() {
        return chargeUnit;
    }

    public void setChargeUnit(float chargeUnit) {
        this.chargeUnit = chargeUnit;
    }

    public Charge(int chargeId, String chargeName, float chargeUnit) {
        this.chargeId = chargeId;
        this.chargeName = chargeName;
        this.chargeUnit = chargeUnit;
    }
    public Charge() {}
}
