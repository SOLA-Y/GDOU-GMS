package com.gdou.gms.pojo;

public class Condition
{
    // 用户条件
    private String username;

    private String gender;

    private Integer roleid;

    // 场地条件
    private Integer state;

    // 器材条件
    private Integer left;

    // 场地条件、器材条件、赛事条件
    private Integer typeId;


    // public Condition()
    // {
    // }
    //
    // public Condition(String username, String gender, Integer roleid)
    // {
    //     this.username = username;
    //     this.gender = gender;
    //     this.roleid = roleid;
    // }
    //
    // public Condition(Integer state, Integer typeId)
    // {
    //     this.state = state;
    //     this.typeId = typeId;
    // }


    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
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

    public Integer getTypeId()
    {
        return typeId;
    }

    public void setTypeId(Integer typeId)
    {
        this.typeId = typeId;
    }
}
