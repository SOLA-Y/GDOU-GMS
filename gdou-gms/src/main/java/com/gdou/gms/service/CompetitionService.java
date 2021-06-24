package com.gdou.gms.service;

import com.gdou.gms.pojo.Competition;
import com.gdou.gms.pojo.Condition;

import java.util.List;

public interface CompetitionService
{

    public Boolean createCompetition(Competition competition);

    public Boolean deleteCompetition(String competitionId);

    public Competition queryCompetition(String competitionId);

    public List<Competition> queryAllCompetitions();

    public List<Competition> queryCompetitionsByCondition(Condition condition);

}
