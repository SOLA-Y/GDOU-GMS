package com.gdou.gms.pojo;

import javax.validation.constraints.Size;
import java.io.Serializable;

public class User implements Serializable {

    @Size(min = 12, max = 12, message = "用户账号长度必须为12位")
    private String userid;

    @Size(min = 10, max = 16, message = "密码长度必须介于10到16位之间")
    private String password;

    private Integer roleid;

    public User()
    {
    }

    public User(String userid, String password, Integer roleid)
    {
        this.userid = userid;
        this.password = password;
        this.roleid = roleid;
    }

    private static final long serialVersionUID = 1L;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userid=").append(userid);
        sb.append(", password=").append(password);
        sb.append(", roleid=").append(roleid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}