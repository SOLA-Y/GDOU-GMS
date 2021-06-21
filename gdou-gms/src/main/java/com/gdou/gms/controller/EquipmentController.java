package com.gdou.gms.controller;

import com.gdou.gms.pojo.Condition;
import com.gdou.gms.pojo.EquOrder;
import com.gdou.gms.pojo.Equipment;
import com.gdou.gms.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class EquipmentController
{
    @Autowired
    private EquipmentService equipmentService;

    @PostMapping("/addEquipment")
    public Boolean addEquipment(@RequestBody Equipment equipment)
    {
        return equipmentService.addEquipment(equipment);
    }

    @GetMapping("/deleteEquipment")
    public Boolean deleteEquipment(@RequestParam("equId") Integer equId)
    {
        return equipmentService.deleteEquipment(equId);
    }

    @GetMapping("/queryEquipment")
    public Equipment queryEquipment(@RequestParam("equId") Integer equId)
    {
        return equipmentService.queryEquipment(equId);
    }

    @GetMapping("/queryAllEquipments")
    public List<Equipment> queryAllEquipments()
    {
        return equipmentService.queryAllEquipments();
    }

    @PostMapping("/queryEqusByCondition")
    public List<Equipment> queryEqusByCondition(@RequestBody Condition condition)
    {
        return equipmentService.queryEquipmentsByCondition(condition);
    }

    @PostMapping("/updateEquipment")
    public Boolean updateEquipment(@RequestBody Equipment equipment)
    {
        return equipmentService.updateEquipment(equipment);
    }

    @PostMapping("/addEquOrder")
    public Boolean addEquOrder(@RequestBody EquOrder equOrder)
    {
        return equipmentService.addEquOrder(equOrder);
    }

    @GetMapping("/deleteEquOrder")
    public Boolean deleteEquOrder(@RequestParam("equOrderId") Integer equOrderId)
    {
        return equipmentService.deleteEquOrder(equOrderId);
    }

    @GetMapping("/queryEquOrder")
    public EquOrder queryEquOrder(@RequestParam("equOrderId") Integer equOrderId)
    {
        return equipmentService.queryEquOrder(equOrderId);
    }

    @GetMapping("/queryAllEquOrders")
    public List<EquOrder> queryAllEquOrders()
    {
        return equipmentService.queryAllEquOrders();
    }

    @GetMapping("/queryEquOrdersByType")
    public List<EquOrder> queryEquOrdersByType(@RequestParam("typeId") Integer typeId)
    {
        return equipmentService.queryEquOrdersByType(typeId);
    }

    @GetMapping("/queryEquOrdersByStatus")
    public List<EquOrder> queryEquOrdersByStatus(@RequestParam("status") Integer status)
    {
        return equipmentService.queryEquOrdersByStatus(status);
    }

    // 场地预约审核通过
    @GetMapping("/verifiedEquOrder")
    public Boolean verifiedEquOrder(@RequestParam("equOrderId") Integer equOrderId)
    {
        return equipmentService.verifiedEquOrder(equOrderId);
    }

    // 场地归还
    @GetMapping("/returnEquipment")
    public Boolean returnEquipment(@RequestParam("equOrderId") Integer equOrderId)
    {
        return equipmentService.returnEquipment(equOrderId);
    }


}
