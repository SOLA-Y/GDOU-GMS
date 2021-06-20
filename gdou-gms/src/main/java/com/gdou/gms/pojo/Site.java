package com.gdou.gms.pojo;

import java.io.Serializable;

public class Site implements Serializable {
    private Integer siteid;

    private String siteNum;

    private String siteArea;

    private Integer feeid;

    private Integer state;

    private Integer typeid;

    private static final long serialVersionUID = 1L;

    public Integer getSiteid() {
        return siteid;
    }

    public void setSiteid(Integer siteid) {
        this.siteid = siteid;
    }

    public String getSiteNum() {
        return siteNum;
    }

    public void setSiteNum(String siteNum) {
        this.siteNum = siteNum;
    }

    public String getSiteArea() {
        return siteArea;
    }

    public void setSiteArea(String siteArea) {
        this.siteArea = siteArea;
    }

    public Integer getFeeid() {
        return feeid;
    }

    public void setFeeid(Integer feeid) {
        this.feeid = feeid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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
        sb.append(", siteid=").append(siteid);
        sb.append(", siteNum=").append(siteNum);
        sb.append(", siteArea=").append(siteArea);
        sb.append(", feeid=").append(feeid);
        sb.append(", state=").append(state);
        sb.append(", typeid=").append(typeid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}