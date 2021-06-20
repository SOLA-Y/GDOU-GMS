package com.gdou.gms.service;

import com.gdou.gms.pojo.Site;
import com.gdou.gms.pojo.SiteOrder;

import java.util.List;

public interface SiteService
{

    public Boolean addSite(Site site);

    public Boolean deleteSite(Integer siteId);

    public Site querySite(Integer siteId);

    public List<Site> queryAllSites();

    public Boolean updateSite(Site site);

    public Boolean createSiteOrder(SiteOrder siteOrder);

    public Boolean deleteSiteOrder(Integer siteOrderId);

    public SiteOrder querySiteOrder(Integer siteOrderId);

    public List<SiteOrder> queryAllSiteOrders();

}
