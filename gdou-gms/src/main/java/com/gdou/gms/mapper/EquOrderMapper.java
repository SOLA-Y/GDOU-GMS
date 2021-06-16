package com.gdou.gms.mapper;

import com.gdou.gms.pojo.EquOrder;
import com.gdou.gms.pojo.EquOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EquOrderMapper {
    long countByExample(EquOrderExample example);

    int deleteByExample(EquOrderExample example);

    int deleteByPrimaryKey(Integer orderid);

    int insert(EquOrder record);

    int insertSelective(EquOrder record);

    List<EquOrder> selectByExample(EquOrderExample example);

    EquOrder selectByPrimaryKey(Integer orderid);

    int updateByExampleSelective(@Param("record") EquOrder record, @Param("example") EquOrderExample example);

    int updateByExample(@Param("record") EquOrder record, @Param("example") EquOrderExample example);

    int updateByPrimaryKeySelective(EquOrder record);

    int updateByPrimaryKey(EquOrder record);
}