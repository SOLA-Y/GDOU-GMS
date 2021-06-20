package com.gdou.gms.service.Impl;

import com.gdou.gms.mapper.SiteMapper;
import com.gdou.gms.mapper.SiteOrderMapper;
import com.gdou.gms.pojo.Site;
import com.gdou.gms.pojo.SiteOrder;
import com.gdou.gms.service.SiteService;
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
        int insert = siteMapper.insert(site);
        return insert == 1;
    }

    @Override
    public Boolean deleteSite(Integer siteId)
    {
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
    public Boolean updateSite(Site site)
    {
        int update = siteMapper.updateByPrimaryKeySelective(site);
        return update == 1;
    }

    @Override
    public Boolean createSiteOrder(SiteOrder siteOrder)
    {
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
        return null;
    }

    @Override
    public List<SiteOrder> queryAllSiteOrders()
    {
        return null;
    }
}
