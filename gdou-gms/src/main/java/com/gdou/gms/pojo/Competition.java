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

    private SiteOrder siteOrder;

    private Site site;

    private EquOrder equOrder;

    private Equipment equipment;

    private UserInfo userInfo;

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

    public SiteOrder getSiteOrder()
    {
        return siteOrder;
    }

    public void setSiteOrder(SiteOrder siteOrder)
    {
        this.siteOrder = siteOrder;
    }

    public Site getSite()
    {
        return site;
    }

    public void setSite(Site site)
    {
        this.site = site;
    }

    public EquOrder getEquOrder()
    {
        return equOrder;
    }

    public void setEquOrder(EquOrder equOrder)
    {
        this.equOrder = equOrder;
    }

    public Equipment getEquipment()
    {
        return equipment;
    }

    public void setEquipment(Equipment equipment)
    {
        this.equipment = equipment;
    }

    public UserInfo getUserInfo()
    {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo)
    {
        this.userInfo = userInfo;
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
        sb.append(", siteOrder=").append(siteOrder);
        sb.append(", site=").append(site);
        sb.append(", equOrder=").append(equOrder);
        sb.append(", equipment=").append(equipment);
        sb.append(", userInfo=").append(userInfo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}