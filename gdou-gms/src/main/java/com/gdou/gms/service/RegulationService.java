package com.gdou.gms.service;

import com.gdou.gms.pojo.Regulation;

import java.util.List;

public interface RegulationService
{

    public Boolean createRegulation(Regulation regulation);

    public Boolean deleteRegulation(Integer regulationId);

    public Regulation queryRegulation(Integer regulationId);

    public List<Regulation> queryAllRegulations();

    public Boolean updateRegulation(Regulation regulation);

}
