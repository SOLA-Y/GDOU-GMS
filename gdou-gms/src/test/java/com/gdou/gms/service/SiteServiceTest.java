package com.gdou.gms.service;

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
    void querySiteOrdersByStatus()
    {
        System.out.println(siteService.querySiteOrdersByStatus(1));
    }
}