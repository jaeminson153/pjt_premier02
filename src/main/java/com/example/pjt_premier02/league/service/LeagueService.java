package com.example.pjt_premier02.league.service;

import java.util.List;

import com.example.pjt_premier02.league.dto.LeagueDTO;

public interface LeagueService {
	
	public List<LeagueDTO> listLeague();
	public LeagueDTO contentLeague(long clubNo);
}
