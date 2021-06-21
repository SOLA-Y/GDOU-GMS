package com.gdou.gms.service;

import cn.hutool.core.date.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

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
    void queryCompetitionsByStatus()
    {
        System.out.println("1=" + String.valueOf(DateUtil.current()));
        // System.out.println("----------------------------------------");
        // System.out.println(competitionService.queryCompetitionsByStatus(1));
        // System.out.println("----------------------------------------");
        System.out.println("2=" + String.valueOf(DateUtil.current()));

    }
}