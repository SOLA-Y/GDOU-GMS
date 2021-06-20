package com.gdou.gms.controller;

import com.gdou.gms.pojo.Condition;
import com.gdou.gms.pojo.Site;
import com.gdou.gms.pojo.SiteOrder;
import com.gdou.gms.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class SiteController
{
    @Autowired
    private SiteService siteService;

    @PostMapping("/addSite")
    public Boolean addSite(@RequestBody Site site)
    {
        return siteService.addSite(site);
    }

    @GetMapping("/deleteSite")
    public Boolean deleteSite(@RequestParam("siteId") Integer siteId)
    {
        return siteService.deleteSite(siteId);
    }

    @GetMapping("/querySite")
    public Site querySite(@RequestParam("siteId") Integer siteId)
    {
        return siteService.querySite(siteId);
    }

    @GetMapping("/queryAllSites")
    public List<Site> queryAllSites()
    {
        return siteService.queryAllSites();
    }

    // 按照场地使用状态或类型查询场地
    @PostMapping("/querySitesByCondition")
    public List<Site> querySitesByCondition(@RequestBody Condition condition)
    {
        return siteService.querySitesByCondition(condition);
    }

    @PostMapping("/updateSite")
    public Boolean updateSite(@RequestBody Site site)
    {
        return siteService.updateSite(site);
    }

    @PostMapping("/addSiteOrder")
    public Boolean addSiteOrder(@RequestBody SiteOrder siteOrder)
    {
        return siteService.addSiteOrder(siteOrder);
    }

    @GetMapping("/deleteSiteOrder")
    public Boolean deleteSiteOrder(@RequestParam("siteOrderId") Integer siteOrderId)
    {
        return siteService.deleteSiteOrder(siteOrderId);
    }

    @GetMapping("/querySiteOrder")
    public SiteOrder querySiteOrder(@RequestParam("siteOrderId") Integer siteOrderId)
    {
        return siteService.querySiteOrder(siteOrderId);
    }

    @GetMapping("/queryAllSiteOrders")
    public List<SiteOrder> queryAllSiteOrders()
    {
        return siteService.queryAllSiteOrders();
    }

    @GetMapping("/querySiteOrdersByType")
    public List<SiteOrder> querySiteOrdersByType(@RequestParam("typeId") Integer typeId)
    {
        return siteService.querySiteOrdersByType(typeId);
    }

    @GetMapping("/querySiteOrdersByStatus")
    public List<SiteOrder> querySiteOrdersByStatus(@RequestParam("status") Integer status)
    {
        return siteService.querySiteOrdersByStatus(status);
    }

    // 场地预约审核通过
    @GetMapping("/verifiedSiteOrder")
    public Boolean verifiedSiteOrder(@RequestParam("siteOrderId") Integer siteOrderId)
    {
        return siteService.verifiedSiteOrder(siteOrderId);
    }

    // 场地归还
    @GetMapping("/returnSite")
    public Boolean returnSite(@RequestParam("siteId") Integer siteId)
    {
        return siteService.returnSite(siteId);
    }

}
