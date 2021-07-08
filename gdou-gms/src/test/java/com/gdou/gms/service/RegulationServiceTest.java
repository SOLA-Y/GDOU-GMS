package com.gdou.gms.service;

import com.gdou.gms.mapper.RegulationMapper;
import com.gdou.gms.pojo.Regulation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RegulationServiceTest
{

    @Autowired
    private RegulationMapper regulationMapper;

    @Autowired
    private RegulationService regulationService;

    @Test
    void createRegulation()
    {
        Regulation regulation = new Regulation(null, "201820182018", "阿生的标题", new Date(), "阿生随便写的内容");
        regulationMapper.insert(regulation);
    }

    @Test
    void queryRegulation()
    {
        System.out.println(regulationMapper.selectRegulationAndUserById(2));
    }

    @Test
    void queryAllRegulations()
    {
        System.out.println(regulationService.queryAllRegulations());
    }

}