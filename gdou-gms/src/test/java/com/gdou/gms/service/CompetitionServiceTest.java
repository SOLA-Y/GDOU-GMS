package com.gdou.gms.service;

import com.gdou.gms.pojo.Condition;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CompetitionServiceTest
{

    @Autowired
    private CompetitionService competitionService;

    @Test
    void queryCompetition()
    {
        System.out.println(competitionService.queryCompetition("01234567899876543210"));
    }

    @Test
    void queryCompetitionsByCondition()
    {
        Condition condition = new Condition();
        condition.setTypeId(1);
        condition.setStatus(0);

        System.out.println(competitionService.queryCompetitionsByCondition(condition));
    }

    @Test
    void queryCompetitionsByUserId()
    {
        System.out.println(competitionService.queryCompetitionsByUserId("201811701310"));
    }
}