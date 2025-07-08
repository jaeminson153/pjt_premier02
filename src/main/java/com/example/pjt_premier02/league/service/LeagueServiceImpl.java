package com.example.pjt_premier02.league.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pjt_premier02.league.dto.LeagueDTO;
import com.example.pjt_premier02.league.entity.LeagueEntity;
import com.example.pjt_premier02.league.repository.LeagueRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LeagueServiceImpl implements LeagueService{
	@Autowired
	private LeagueRepository leagueRepository;	
	
	public LeagueServiceImpl() {
	
	}

	@Override
	public List<LeagueDTO> listLeague() {
		List<LeagueEntity> listLeagueEntity = leagueRepository.findLeagueList();
		List<LeagueDTO> listLeagueDTO = listLeagueEntity.stream().map(LeagueDTO::toDTO).collect(Collectors.toList());

		return listLeagueDTO;
	}

	@Override
	public LeagueDTO contentLeague(long clubNo) {
		LeagueEntity leagueEntity = leagueRepository.findLeagueByClubNo(clubNo);
		return LeagueDTO.toDTO(leagueEntity);	
	}

}
