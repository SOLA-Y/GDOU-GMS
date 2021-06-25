package com.gdou.gms.service;

import com.gdou.gms.pojo.Condition;
import com.gdou.gms.pojo.Equipment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Date;

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
    void addEquipment()
    {
        // System.out.println(new Date());

        Equipment equipment = new Equipment();
        equipment.setEquName("篮球");
        equipment.setEquFee(new BigDecimal(2.00));
        equipment.setTotalCost(new BigDecimal(1000.00));
        equipment.setQuantity(100);
        equipment.setLeft(100);
        equipment.setBuyDate(new Date());
        equipment.setTypeid(1);

        equipmentService.addEquipment(equipment);

    }

    @Test
    void queryEquOrdersByCondition()
    {
        Condition condition = new Condition();
        condition.setTypeId(1);
        condition.setStatus(0);

        System.out.println(equipmentService.queryEquOrdersByCondition(condition));
    }

    @Test
    void queryEquOrdersByUserId()
    {
        System.out.println(equipmentService.queryEquOrdersByUserId("201811701311"));
    }

    @Test
    void queryEquipmentsByCondition()
    {
        Condition condition = new Condition();
        condition.setTypeId(1);

        System.out.println(equipmentService.queryEquipmentsByCondition(condition));

    }
}