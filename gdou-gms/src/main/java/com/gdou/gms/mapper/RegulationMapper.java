package com.gdou.gms.mapper;

import com.gdou.gms.pojo.Regulation;
import com.gdou.gms.pojo.RegulationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RegulationMapper {
    long countByExample(RegulationExample example);

    int deleteByExample(RegulationExample example);

    int deleteByPrimaryKey(Integer regulationid);

    int insert(Regulation record);

    int insertSelective(Regulation record);

    List<Regulation> selectByExampleWithBLOBs(RegulationExample example);

    List<Regulation> selectByExample(RegulationExample example);

    Regulation selectByPrimaryKey(Integer regulationid);

    Regulation selectRegulationAndUserById(Integer regulationid);

    List<Regulation> selectAllRegulationsAndUsers();

    int updateByExampleSelective(@Param("record") Regulation record, @Param("example") RegulationExample example);

    int updateByExampleWithBLOBs(@Param("record") Regulation record, @Param("example") RegulationExample example);

    int updateByExample(@Param("record") Regulation record, @Param("example") RegulationExample example);

    int updateByPrimaryKeySelective(Regulation record);

    int updateByPrimaryKeyWithBLOBs(Regulation record);

    int updateByPrimaryKey(Regulation record);
}