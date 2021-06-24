package com.gdou.gms.service.Impl;

import com.gdou.gms.mapper.CompetitionMapper;
import com.gdou.gms.pojo.Competition;
import com.gdou.gms.pojo.Condition;
import com.gdou.gms.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetitionServiceImpl implements CompetitionService
{
    @Autowired
    private CompetitionMapper competitionMapper;

    @Override
    public Boolean createCompetition(Competition competition)
    {
        int insert = competitionMapper.insert(competition);
        return insert == 1;
    }

    @Override
    public Boolean deleteCompetition(String competitionId)
    {
        int delete = competitionMapper.deleteByPrimaryKey(competitionId);
        return delete == 1;
    }

    @Override
    public Competition queryCompetition(String competitionId)
    {
        return competitionMapper.selectCompetitionById(competitionId);
    }

    @Override
    public List<Competition> queryAllCompetitions()
    {
        return competitionMapper.selectAllCompetitions();
    }

    @Override
    public List<Competition> queryCompetitionsByCondition(Condition condition)
    {
        return competitionMapper.selectCompetitionsByCondition(condition);
    }

}
