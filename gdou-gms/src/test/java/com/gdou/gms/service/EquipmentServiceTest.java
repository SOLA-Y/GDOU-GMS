package com.gdou.gms.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EquipmentServiceTest
{
    @Autowired
    private EquipmentService equipmentService;

    @Test
    void queryEquOrder()
    {
        System.out.println(equipmentService.queryEquOrder(1));
    }

    @Test
    void queryAllEquOrders()
    {
    }

    @Test
    void queryEquOrdersByType()
    {
    }

    @Test
    void queryEquOrdersByStatus()
    {
        System.out.println(equipmentService.queryEquOrdersByStatus(1));
    }

}