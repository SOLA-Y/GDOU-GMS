package com.gdou.gms.mapper;

import com.gdou.gms.pojo.Condition;
import com.gdou.gms.pojo.SiteOrder;
import com.gdou.gms.pojo.SiteOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SiteOrderMapper {
    long countByExample(SiteOrderExample example);

    int deleteByExample(SiteOrderExample example);

    int deleteByPrimaryKey(Integer orderid);

    int insert(SiteOrder record);

    int insertSelective(SiteOrder record);

    List<SiteOrder> selectByExample(SiteOrderExample example);

    SiteOrder selectByPrimaryKey(Integer orderid);

    List<SiteOrder> selectAllOrdersAndSitesAndUsers();

    SiteOrder selectOrderAndSiteAndUserById(Integer orderid);

    List<SiteOrder> selectOrderAndSiteAndUserByCondition(@Param("condition") Condition condition);

    List<SiteOrder> selectOrderAndSiteAndUserByUserId(String userId);

    int updateByExampleSelective(@Param("record") SiteOrder record, @Param("example") SiteOrderExample example);

    int updateByExample(@Param("record") SiteOrder record, @Param("example") SiteOrderExample example);

    int updateByPrimaryKeySelective(SiteOrder record);

    int updateByPrimaryKey(SiteOrder record);
}