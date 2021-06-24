package com.gdou.gms.service.Impl;

import com.gdou.gms.mapper.EquOrderMapper;
import com.gdou.gms.mapper.EquipmentMapper;
import com.gdou.gms.pojo.*;
import com.gdou.gms.service.EquipmentService;
import com.gdou.gms.util.ExampleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EquipmentServiceImpl implements EquipmentService
{
    @Autowired
    private EquipmentMapper equipmentMapper;

    @Autowired
    private EquOrderMapper equOrderMapper;

    @Override
    public Boolean addEquipment(Equipment equipment)
    {
        EquipmentExample example = new EquipmentExample();
        EquipmentExample.Criteria criteria = example.createCriteria();

        criteria.andTypeidEqualTo(equipment.getTypeid());

        List<Equipment> equipmentList = equipmentMapper.selectByExample(example);

        if (equipmentList.size() != 0)
        {
            Equipment dbEquipment = equipmentList.get(0);
            dbEquipment.setTotalCost(dbEquipment.getTotalCost().add(equipment.getTotalCost()));
            dbEquipment.setQuantity(dbEquipment.getQuantity() + equipment.getQuantity());
            dbEquipment.setLeft(dbEquipment.getLeft() + equipment.getLeft());

            int update = equipmentMapper.updateByExampleSelective(dbEquipment, example);
            return update == 1;
        }
        else
        {
            int insert = equipmentMapper.insert(equipment);
            return insert == 1;
        }
    }

    @Override
    public Boolean deleteEquipment(Integer equId)
    {
        int delete = equipmentMapper.deleteByPrimaryKey(equId);
        return delete == 1;
    }

    @Override
    public Equipment queryEquipment(Integer equId)
    {
        return equipmentMapper.selectByPrimaryKey(equId);
    }

    @Override
    public List<Equipment> queryAllEquipments()
    {
        return equipmentMapper.selectByExample(null);
    }

    @Override
    public List<Equipment> queryEquipmentsByCondition(Condition condition)
    {
        EquipmentExample example = ExampleUtil.createEquipmentExample(condition);
        return equipmentMapper.selectByExample(example);
    }

    @Override
    public Boolean updateEquipment(Equipment equipment)
    {
        int update = equipmentMapper.updateByPrimaryKeySelective(equipment);
        return update == 1;
    }

    @Transactional
    @Override
    public Boolean returnEquipment(Integer equOrderId)
    {
        EquOrder equOrder = equOrderMapper.selectByPrimaryKey(equOrderId);
        Equipment equipment = equipmentMapper.selectByPrimaryKey(equOrder.getEquid());

        equipment.setLeft(equipment.getLeft() + equOrder.getNum());
        Boolean update1 = updateEquipment(equipment);

        equOrder.setStatus(3);
        int update2 = equOrderMapper.updateByPrimaryKeySelective(equOrder);

        return update1 && update2 == 1;
    }

    @Override
    public Boolean addEquOrder(EquOrder equOrder)
    {
        equOrder.setStatus(0);
        int insert = equOrderMapper.insert(equOrder);
        return insert == 1;
    }

    @Transactional
    @Override
    public Boolean repairEquipment(EquOrder equOrder)
    {
        Equipment equipment = equipmentMapper.selectByPrimaryKey(equOrder.getEquid());
        equipment.setLeft(equipment.getLeft() - equOrder.getNum());
        int update = equipmentMapper.updateByPrimaryKey(equipment);
        equOrder.setStatus(2);
        int insert = equOrderMapper.insert(equOrder);

        return update == insert && update == 1;
    }

    @Override
    public Boolean deleteEquOrder(Integer equOrderId)
    {
        int delete = equOrderMapper.deleteByPrimaryKey(equOrderId);
        return delete == 1;
    }

    @Override
    public Boolean deleteEquOrderByCompetId(String competitionId)
    {
        EquOrderExample example = new EquOrderExample();
        EquOrderExample.Criteria criteria = example.createCriteria();
        criteria.andCompetidEqualTo(competitionId);

        int delete = equOrderMapper.deleteByExample(example);

        return delete == 1;
    }

    @Override
    public EquOrder queryEquOrderByCompetId(String competitionId)
    {
        EquOrderExample example = new EquOrderExample();
        EquOrderExample.Criteria criteria = example.createCriteria();
        criteria.andCompetidEqualTo(competitionId);

        List<EquOrder> equOrderList = equOrderMapper.selectByExample(example);

        return equOrderList.get(0);
    }

    @Override
    public EquOrder queryEquOrder(Integer equOrderId)
    {
        return equOrderMapper.selectOrderAndEquAndUserById(equOrderId);
    }

    @Override
    public List<EquOrder> queryAllEquOrders()
    {
        return equOrderMapper.selectAllOrdersAndEqusAndUsers();
    }

    @Override
    public List<EquOrder> queryEquOrdersByType(Integer typeId)
    {
        return equOrderMapper.selectOrderAndEquAndUserByType(typeId);
    }

    @Override
    public List<EquOrder> queryEquOrdersByStatus(Integer status)
    {
        return equOrderMapper.selectOrderAndEquAndUserByStatus(status);
    }

    @Transactional
    @Override
    public Boolean verifiedEquOrder(Integer equOrderId)
    {
        EquOrder equOrder = equOrderMapper.selectByPrimaryKey(equOrderId);
        Equipment equipment = equipmentMapper.selectByPrimaryKey(equOrder.getEquid());

        equipment.setLeft(equipment.getLeft() - equOrder.getNum());
        int update1 = equipmentMapper.updateByPrimaryKeySelective(equipment);

        equOrder.setStatus(1);
        int update2 = equOrderMapper.updateByPrimaryKeySelective(equOrder);

        return update1 == update2 && update1 == 1;
    }

}
