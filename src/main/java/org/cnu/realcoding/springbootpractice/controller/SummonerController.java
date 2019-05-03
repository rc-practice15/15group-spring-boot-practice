package org.cnu.realcoding.springbootpractice.controller;


import org.cnu.realcoding.springbootpractice.domain.LeaguePosition;
import org.cnu.realcoding.springbootpractice.repository.SpringBootPracticeRepository;
import org.cnu.realcoding.springbootpractice.service.SummonerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SummonerController {

    @Autowired
    private SummonerService summonerService;
    @Autowired
    private SpringBootPracticeRepository springBootPracticeRepository;

    @GetMapping("/lol/summoner/Id/by-name")
    public String getSummonerId(@RequestParam String summonerName) {
        return summonerService.getSummonerId(summonerName);
    }

    @GetMapping("/lol/league/insertPositions/by-id")
    public LeaguePosition insertSummonerInformationById(@RequestParam String id) {
        LeaguePosition[] leaguePosition = summonerService.getLeaguePosition(id);
        springBootPracticeRepository.insertLeaguePosition(leaguePosition);

        return leaguePosition[0];
    }

    @GetMapping("/lol/league/insertPositions/by-name")
    public LeaguePosition insertSummonerInformationByName(@RequestParam String summonerName) {
        String id = summonerService.getSummonerId(summonerName);
        LeaguePosition[] leaguePosition = summonerService.getLeaguePosition(id);
        springBootPracticeRepository.insertLeaguePosition(leaguePosition);

        return leaguePosition[0];
    }



}
