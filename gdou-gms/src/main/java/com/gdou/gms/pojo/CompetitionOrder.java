package com.gdou.gms.pojo;

public class CompetitionOrder
{
    private Competition competition;
    private SiteOrder siteOrder;
    private EquOrder equOrder;

    public Competition getCompetition()
    {
        return competition;
    }

    public void setCompetition(Competition competition)
    {
        this.competition = competition;
    }

    public SiteOrder getSiteOrder()
    {
        return siteOrder;
    }

    public void setSiteOrder(SiteOrder siteOrder)
    {
        this.siteOrder = siteOrder;
    }

    public EquOrder getEquOrder()
    {
        return equOrder;
    }

    public void setEquOrder(EquOrder equOrder)
    {
        this.equOrder = equOrder;
    }

    @Override
    public String toString()
    {
        return "CompetitionOrder{" +
                "competition=" + competition +
                ", siteOrder=" + siteOrder +
                ", equOrder=" + equOrder +
                '}';
    }
}
