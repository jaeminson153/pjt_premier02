package com.example.pjt_premier02.league.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.pjt_premier02.league.dto.LeagueDTO;
import com.example.pjt_premier02.league.repository.LeagueRepository;
import com.example.pjt_premier02.league.service.LeagueService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class LeagueController {
    private final LeagueRepository leagueRepository;
    
    @Autowired
	private LeagueService leagueService;
    
    public LeagueController(LeagueRepository leagueRepository) {
		this.leagueRepository = leagueRepository;
	}
    
    // http://localhost:8090/league/list
    @GetMapping(value="/league/list")
    public ResponseEntity<Map<String, Object>> listExecute(){
        Map<String, Object> map = new HashMap<>();
 		
   		map.put("leagueList", leagueService.listLeague());

    	return ResponseEntity.ok().body(map);
    }//end listExecute()//////    
    
    @GetMapping(value="/league/view/{clubNo}")
    public ResponseEntity<LeagueDTO> viewExecute(@PathVariable("clubNo") Long clubNo){
    	LeagueDTO leagueDTO = leagueService.contentLeague(clubNo);
    	return ResponseEntity.ok(leagueDTO);
    }      
}
