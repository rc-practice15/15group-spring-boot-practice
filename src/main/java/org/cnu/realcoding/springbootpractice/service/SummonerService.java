package org.cnu.realcoding.springbootpractice.service;

import org.cnu.realcoding.springbootpractice.api.ApiClient;
import org.cnu.realcoding.springbootpractice.domain.LeaguePosition;
import org.cnu.realcoding.springbootpractice.repository.SpringBootPracticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SummonerService {
    @Autowired
    private ApiClient apiClinent;
    @Autowired
    private SpringBootPracticeRepository springBootPracticeRepository;

    public String getSummonerId(String summonerName) {
        return apiClinent.getSummonerByName(summonerName).getId();
    }

    public LeaguePosition[] getLeaguePosition(String id) {
        return apiClinent.getLeaguePositionByEncryptedSummonerId(id);
    }
}
