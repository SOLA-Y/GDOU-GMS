package com.gdou.gms.service.Impl;

import com.gdou.gms.mapper.SiteMapper;
import com.gdou.gms.mapper.SiteOrderMapper;
import com.gdou.gms.pojo.*;
import com.gdou.gms.service.SiteService;
import com.gdou.gms.util.ExampleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteServiceImpl implements SiteService
{
    @Autowired
    private SiteMapper siteMapper;

    @Autowired
    private SiteOrderMapper siteOrderMapper;

    @Override
    public Boolean addSite(Site site)
    {
        site.setState(0);
        int insert = siteMapper.insert(site);
        return insert == 1;
    }

    @Override
    public Boolean deleteSite(Integer siteId)
    {
        SiteOrderExample example = new SiteOrderExample();
        SiteOrderExample.Criteria criteria = example.createCriteria();
        criteria.andSiteidEqualTo(siteId);
        siteOrderMapper.deleteByExample(example);

        int delete = siteMapper.deleteByPrimaryKey(siteId);
        return delete == 1;
    }

    @Override
    public Site querySite(Integer siteId)
    {
        return siteMapper.selectByPrimaryKey(siteId);
    }

    @Override
    public List<Site> queryAllSites()
    {
        return siteMapper.selectByExample(null);
    }

    @Override
    public List<Site> querySitesByCondition(Condition condition)
    {
        SiteExample example = ExampleUtil.createSiteExample(condition);
        return siteMapper.selectByExample(example);
    }

    @Override
    public Boolean updateSite(Site site)
    {
        int update = siteMapper.updateByPrimaryKeySelective(site);
        return update == 1;
    }

    @Override
    public Boolean addSiteOrder(SiteOrder siteOrder)
    {
        siteOrder.setStatus(0);
        int insert = siteOrderMapper.insert(siteOrder);
        return insert == 1;
    }

    @Override
    public Boolean deleteSiteOrder(Integer siteOrderId)
    {
        int delete = siteOrderMapper.deleteByPrimaryKey(siteOrderId);
        return delete == 1;
    }

    @Override
    public SiteOrder querySiteOrder(Integer siteOrderId)
    {
        return siteOrderMapper.selectOrderAndSiteAndUserById(siteOrderId);
    }

    @Override
    public List<SiteOrder> queryAllSiteOrders()
    {
        return siteOrderMapper.selectAllOrdersAndSitesAndUsers();
    }

    @Override
    public List<SiteOrder> querySiteOrdersByType(Integer typeId)
    {
        return siteOrderMapper.selectOrderAndSiteAndUserByType(typeId);
    }

    @Override
    public List<SiteOrder> querySiteOrdersByStatus(Integer status)
    {
        return siteOrderMapper.selectOrderAndSiteAndUserByStatus(status);
    }

    @Override
    public Boolean updateSiteOrder(Integer siteOrderId)
    {
        SiteOrder siteOrder = siteOrderMapper.selectByPrimaryKey(siteOrderId);
        Site site = siteMapper.selectByPrimaryKey(siteOrder.getSiteid());

        site.setState(1);
        int update1 = siteMapper.updateByPrimaryKeySelective(site);

        siteOrder.setStatus(1);
        int update2 = siteOrderMapper.updateByPrimaryKey(siteOrder);

        return update1 == update2 && update1 == 1;
    }
}
