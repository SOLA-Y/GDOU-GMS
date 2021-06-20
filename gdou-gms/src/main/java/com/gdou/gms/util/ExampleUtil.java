package com.gdou.gms.util;

import cn.hutool.core.util.StrUtil;
import com.gdou.gms.pojo.Condition;
import com.gdou.gms.pojo.EquipmentExample;
import com.gdou.gms.pojo.SiteExample;
import com.gdou.gms.pojo.UserInfoExample;

public class ExampleUtil
{

    public static UserInfoExample createUserInfoExample(Condition condition)
    {
        UserInfoExample example = new UserInfoExample();
        UserInfoExample.Criteria criteria = example.createCriteria();

        if (StrUtil.isNotBlank(condition.getUsername()))
        {
            criteria.andUsernameLike("%" + condition.getUsername() + "%");
        }
        if (StrUtil.isNotBlank(condition.getGender()))
        {
            criteria.andGenderEqualTo(condition.getGender());
        }
        if (condition.getRoleid() != null)
        {
            criteria.andRoleidEqualTo(condition.getRoleid());
        }

        return example;
    }

    public static SiteExample createSiteExample(Condition condition)
    {
        SiteExample example = new SiteExample();
        SiteExample.Criteria criteria = example.createCriteria();

        if (condition.getState() != null)
        {
            criteria.andStateEqualTo(condition.getState());
        }
        if (condition.getTypeId() != null)
        {
            criteria.andTypeidEqualTo(condition.getTypeId());
        }

        return example;
    }

    public static EquipmentExample createEquExample(Condition condition)
    {
        EquipmentExample example = new EquipmentExample();
        EquipmentExample.Criteria criteria = example.createCriteria();

        if (condition.getTypeId() != null)
        {
            criteria.andTypeidEqualTo(condition.getTypeId());
        }
        if (condition.getLeft() != null)
        {
            criteria.andLeftGreaterThan(0);
        }

        return example;
    }




}
