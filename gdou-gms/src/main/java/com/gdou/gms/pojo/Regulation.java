package com.gdou.gms.pojo;

import java.io.Serializable;
import java.util.Date;

public class Regulation implements Serializable {
    private Integer regulationid;

    private String adminid;

    private String title;

    private Date publishTime;

    private String content;

    private static final long serialVersionUID = 1L;

    public Integer getRegulationid() {
        return regulationid;
    }

    public void setRegulationid(Integer regulationid) {
        this.regulationid = regulationid;
    }

    public String getAdminid() {
        return adminid;
    }

    public void setAdminid(String adminid) {
        this.adminid = adminid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", regulationid=").append(regulationid);
        sb.append(", adminid=").append(adminid);
        sb.append(", title=").append(title);
        sb.append(", publishTime=").append(publishTime);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}