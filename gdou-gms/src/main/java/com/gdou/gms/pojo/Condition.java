package com.gdou.gms.pojo;

public class Condition
{
    private String username;

    private String gender;

    private Integer roleid;

    public Condition()
    {
    }

    public Condition(String username, String gender, Integer roleid)
    {
        this.username = username;
        this.gender = gender;
        this.roleid = roleid;
    }

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
}
