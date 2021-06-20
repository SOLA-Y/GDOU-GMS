package com.gdou.gms.controller;

import com.gdou.gms.pojo.Regulation;
import com.gdou.gms.service.RegulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class RegulationController
{
    @Autowired
    private RegulationService regulationService;

    @PostMapping("/createRegulation")
    public Boolean createRegulation(@RequestBody Regulation regulation)
    {
        return regulationService.createRegulation(regulation);
    }

    @GetMapping("/deleteRegulation")
    public Boolean deleteRegulation(@RequestParam("regulationId") Integer regulationId)
    {
        return regulationService.deleteRegulation(regulationId);
    }

    @GetMapping("/queryRegulation")
    public Regulation queryRegulation(@RequestParam("regulationId") Integer regulationId)
    {
        return regulationService.queryRegulation(regulationId);
    }

    @GetMapping("/queryAllRegulations")
    public List<Regulation> queryAllRegulations()
    {
        return regulationService.queryAllRegulations();
    }

    @PostMapping("/updateRegulation")
    public Boolean updateRegulation(@RequestBody Regulation regulation)
    {
        return regulationService.updateRegulation(regulation);
    }

}
