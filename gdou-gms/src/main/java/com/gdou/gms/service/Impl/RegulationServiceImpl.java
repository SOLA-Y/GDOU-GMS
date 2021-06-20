package com.gdou.gms.service.Impl;

import com.gdou.gms.mapper.RegulationMapper;
import com.gdou.gms.pojo.Regulation;
import com.gdou.gms.service.RegulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegulationServiceImpl implements RegulationService
{
    @Autowired
    private RegulationMapper regulationMapper;

    @Override
    public Boolean createRegulation(Regulation regulation)
    {
        int insert = regulationMapper.insert(regulation);
        return insert == 1;
    }

    @Override
    public Boolean deleteRegulation(Integer regulationId)
    {
        int delete = regulationMapper.deleteByPrimaryKey(regulationId);
        return delete == 1;
    }

    @Override
    public Regulation queryRegulation(Integer regulationId)
    {
        return regulationMapper.selectRegulationAndUserById(regulationId);
    }

    @Override
    public List<Regulation> queryAllRegulations()
    {
        return regulationMapper.selectAllRegulationsAndUsers();
    }

    @Override
    public Boolean updateRegulation(Regulation regulation)
    {
        int update = regulationMapper.updateByPrimaryKeySelective(regulation);
        return update == 1;
    }

}
