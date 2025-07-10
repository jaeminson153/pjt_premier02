package com.example.pjt_premier02.league.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.pjt_premier02.league.dto.LeagueDTO;
import com.example.pjt_premier02.league.repository.LeagueRepository;
import com.example.pjt_premier02.league.service.LeagueService;

import jakarta.servlet.http.HttpServletRequest;
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
    
    @PostMapping("/league/update")
    public ResponseEntity<String> updateExecute(@RequestBody List<LeagueDTO> leagueList, HttpServletRequest req){
    	
    	//dto.setIp(req.getRemoteAddr());
    	//leagueService.updateProcess(leagueList);    	
    	//return ResponseEntity.ok(String.valueOf(1));    	
        try {        	
            leagueService.upProcess(leagueList);
            return ResponseEntity.ok("성공적으로 저장되었습니다.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("저장 실패: " + e.getMessage());
        }    	
    }//end writeProExecute()//////////////////////////////////////////////////////        
}
