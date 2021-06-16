package com.gdou.gms.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Equipment implements Serializable {
    private Integer equid;

    private String equName;

    private BigDecimal equFee;

    private BigDecimal totalCost;

    private Integer quantity;

    private Integer left;

    private Date buyDate;

    private String adminid;

    private Integer typeid;

    private static final long serialVersionUID = 1L;

    public Integer getEquid() {
        return equid;
    }

    public void setEquid(Integer equid) {
        this.equid = equid;
    }

    public String getEquName() {
        return equName;
    }

    public void setEquName(String equName) {
        this.equName = equName;
    }

    public BigDecimal getEquFee() {
        return equFee;
    }

    public void setEquFee(BigDecimal equFee) {
        this.equFee = equFee;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getLeft() {
        return left;
    }

    public void setLeft(Integer left) {
        this.left = left;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    public String getAdminid() {
        return adminid;
    }

    public void setAdminid(String adminid) {
        this.adminid = adminid;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", equid=").append(equid);
        sb.append(", equName=").append(equName);
        sb.append(", equFee=").append(equFee);
        sb.append(", totalCost=").append(totalCost);
        sb.append(", quantity=").append(quantity);
        sb.append(", left=").append(left);
        sb.append(", buyDate=").append(buyDate);
        sb.append(", adminid=").append(adminid);
        sb.append(", typeid=").append(typeid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}