package com.gdou.gms.pojo;

import java.io.Serializable;
import java.util.Date;

public class Competition implements Serializable {
    private String competid;

    private String competName;

    private Date startTime;

    private Date endTime;

    private String description;

    private Integer typeid;

    private String userid;

    private Integer siteid;

    private Integer equid;

    private Integer sorderId;

    private Integer eorderId;

    private static final long serialVersionUID = 1L;

    public String getCompetid() {
        return competid;
    }

    public void setCompetid(String competid) {
        this.competid = competid;
    }

    public String getCompetName() {
        return competName;
    }

    public void setCompetName(String competName) {
        this.competName = competName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Integer getSiteid() {
        return siteid;
    }

    public void setSiteid(Integer siteid) {
        this.siteid = siteid;
    }

    public Integer getEquid() {
        return equid;
    }

    public void setEquid(Integer equid) {
        this.equid = equid;
    }

    public Integer getSorderId() {
        return sorderId;
    }

    public void setSorderId(Integer sorderId) {
        this.sorderId = sorderId;
    }

    public Integer getEorderId() {
        return eorderId;
    }

    public void setEorderId(Integer eorderId) {
        this.eorderId = eorderId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", competid=").append(competid);
        sb.append(", competName=").append(competName);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", description=").append(description);
        sb.append(", typeid=").append(typeid);
        sb.append(", userid=").append(userid);
        sb.append(", siteid=").append(siteid);
        sb.append(", equid=").append(equid);
        sb.append(", sorderId=").append(sorderId);
        sb.append(", eorderId=").append(eorderId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}