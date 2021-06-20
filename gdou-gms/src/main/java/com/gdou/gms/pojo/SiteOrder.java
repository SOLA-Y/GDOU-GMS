package com.gdou.gms.pojo;

import java.io.Serializable;
import java.util.Date;

public class SiteOrder implements Serializable {
    private Integer orderid;

    private String userid;

    private Integer siteid;

    private String reason;

    private Date startTime;

    private Date endTime;

    private Integer feeid;

    private Integer status;

    private String competid;

    private Site site;

    private UserInfo userInfo;

    private static final long serialVersionUID = 1L;

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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

    public Integer getFeeid() {
        return feeid;
    }

    public void setFeeid(Integer feeid) {
        this.feeid = feeid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCompetid() {
        return competid;
    }

    public void setCompetid(String competid) {
        this.competid = competid;
    }

    public Site getSite()
    {
        return site;
    }

    public void setSite(Site site)
    {
        this.site = site;
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
        sb.append(", orderid=").append(orderid);
        sb.append(", userid=").append(userid);
        sb.append(", siteid=").append(siteid);
        sb.append(", reason=").append(reason);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", feeid=").append(feeid);
        sb.append(", status=").append(status);
        sb.append(", competid=").append(competid);
        sb.append(", site=").append(site);
        sb.append(", userInfo=").append(userInfo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}