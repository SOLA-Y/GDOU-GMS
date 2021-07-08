package com.gdou.gms.service;

import com.gdou.gms.pojo.Condition;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SiteServiceTest
{
    @Autowired
    private SiteService siteService;

    @Test
    void querySiteOrder()
    {
        System.out.println(siteService.querySiteOrder(1));
    }

    @Test
    void queryAllSiteOrders()
    {
        System.out.println(siteService.queryAllSiteOrders());
    }

    @Test
    void querySiteOrdersByCondition()
    {
        Condition condition = new Condition();
        condition.setTypeId(2);
        condition.setStatus(0);

        System.out.println(siteService.querySiteOrdersByCondition(condition));
    }

    @Test
    void querySiteOrdersByUserId()
    {
        System.out.println(siteService.querySiteOrdersByUserId("201820182018"));
    }
}