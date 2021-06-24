package com.gdou.gms.service;

import com.gdou.gms.pojo.Condition;
import com.gdou.gms.pojo.Site;
import com.gdou.gms.pojo.SiteOrder;

import java.util.List;

public interface SiteService
{

    public Boolean addSite(Site site);

    public Boolean deleteSite(Integer siteId);

    public Site querySite(Integer siteId);

    public List<Site> queryAllSites();

    public List<Site> querySitesByCondition(Condition condition);

    public Boolean updateSite(Site site);

    public Boolean returnSite(Integer siteOrderId);

    public Boolean addSiteOrder(SiteOrder siteOrder);

    public Boolean reservedSite(SiteOrder siteOrder);

    public Boolean deleteSiteOrder(Integer siteOrderId);

    public Boolean deleteSiteOrderByCompetId(String competitionId);

    public SiteOrder querySiteOrderByCompetId(String competitionId);

    public SiteOrder querySiteOrder(Integer siteOrderId);

    public List<SiteOrder> queryAllSiteOrders();

    public List<SiteOrder> querySiteOrdersByCondition(Condition condition);

    public Boolean verifiedSiteOrder(Integer siteOrderId);

}
