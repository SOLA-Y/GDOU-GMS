package com.gdou.gms.pojo;

public class Condition
{
    // 用户条件
    private String username;

    private String userId;

    private Integer roleid;

    // 场地使用状态
    private Integer state;

    // 器材余量
    private Integer left;

    // 订单状态
    private Integer status;

    // 场地条件、器材条件、赛事条件
    private Integer typeId;

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public Integer getRoleid()
    {
        return roleid;
    }

    public void setRoleid(Integer roleid)
    {
        this.roleid = roleid;
    }

    public Integer getState()
    {
        return state;
    }

    public void setState(Integer state)
    {
        this.state = state;
    }

    public Integer getLeft()
    {
        return left;
    }

    public void setLeft(Integer left)
    {
        this.left = left;
    }

    public Integer getStatus()
    {
        return status;
    }

    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public Integer getTypeId()
    {
        return typeId;
    }

    public void setTypeId(Integer typeId)
    {
        this.typeId = typeId;
    }

    @Override
    public String toString()
    {
        return "Condition{" +
                "username='" + username + '\'' +
                ", userId='" + userId + '\'' +
                ", roleid=" + roleid +
                ", state=" + state +
                ", left=" + left +
                ", typeId=" + typeId +
                '}';
    }
}
