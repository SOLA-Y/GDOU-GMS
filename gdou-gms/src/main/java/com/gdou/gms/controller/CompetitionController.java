package com.gdou.gms.controller;

import cn.hutool.core.date.DateUtil;
import com.gdou.gms.pojo.Competition;
import com.gdou.gms.pojo.Condition;
import com.gdou.gms.pojo.EquOrder;
import com.gdou.gms.pojo.SiteOrder;
import com.gdou.gms.service.CompetitionService;
import com.gdou.gms.service.EquipmentService;
import com.gdou.gms.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class CompetitionController
{
    @Autowired
    private CompetitionService competitionService;

    @Autowired
    private SiteService siteService;

    @Autowired
    private EquipmentService equipmentService;

    // 添加赛事
    @PostMapping("/createCompetition")
    public Boolean createCompetition(@RequestBody Competition competition, @RequestBody SiteOrder siteOrder, @RequestBody EquOrder equOrder)
    {
        // 使用时间戳作为赛事id
        String competitionId = String.valueOf(DateUtil.current());

        siteOrder.setCompetid(competitionId);
        if (siteService.addSiteOrder(siteOrder))
        {
            equOrder.setCompetid(competitionId);
            if (equipmentService.addEquOrder(equOrder))
            {

                SiteOrder siteOrder1 = siteService.querySiteOrderByCompetId(competitionId);
                competition.setSorderId(siteOrder1.getOrderid());

                EquOrder equOrder1 = equipmentService.queryEquOrderByCompetId(competitionId);
                competition.setEorderId(equOrder1.getEquid());

                competition.setCompetid(competitionId);
                return competitionService.createCompetition(competition);
            }
        }

        return false;
    }

    // 删除赛事
    @GetMapping("/deleteCompetition")
    public Boolean deleteCompetition(@RequestParam("competid") String competitionId)
    {
        if (siteService.deleteSiteOrderByCompetId(competitionId))
        {
            if (equipmentService.deleteEquOrderByCompetId(competitionId))
            {
                return competitionService.deleteCompetition(competitionId);
            }
        }

        return false;
    }

    // 查询一个赛事
    @GetMapping("/queryCompetition")
    public Competition queryCompetition(@RequestParam("competid") String competitionId)
    {
        return competitionService.queryCompetition(competitionId);
    }

    // 查询所有赛事
    @GetMapping("/queryAllCompetitions")
    public List<Competition> queryAllCompetitions()
    {
        return competitionService.queryAllCompetitions();
    }

    @PostMapping("/queryCompetitionsByCondition")
    public List<Competition> queryCompetitionsByCondition(@RequestBody Condition condition)
    {
        return competitionService.queryCompetitionsByCondition(condition);
    }

    // 赛事申请审核通过
    @GetMapping("/verifiedCompetition")
    public Boolean verifiedCompetition(@RequestParam("competid") String competitionId)
    {
        Competition competition = competitionService.queryCompetition(competitionId);
        Boolean verifiedSiteOrder = siteService.verifiedSiteOrder(competition.getSorderId());
        Boolean verifiedEquOrder = equipmentService.verifiedEquOrder(competition.getEorderId());

        return verifiedSiteOrder && verifiedEquOrder;
    }

    // 赛事场地与器材归还
    @GetMapping("/returnSiteAndEquipment")
    public Boolean returnSiteAndEquipment(@RequestParam("competid") String competitionId)
    {
        Competition competition = competitionService.queryCompetition(competitionId);
        Boolean returnSite = siteService.returnSite(competition.getSorderId());
        Boolean returnEquipment = equipmentService.returnEquipment(competition.getEorderId());

        return returnSite && returnEquipment;
    }

}
