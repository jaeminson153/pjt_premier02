package com.example.pjt_premier02.club.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.pjt_premier02.club.dto.ClubDTO;
import com.example.pjt_premier02.club.repository.ClubRepository;
import com.example.pjt_premier02.club.service.ClubService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ClubController {
	
    private final ClubRepository clubRepository;
    
    @Autowired
	private ClubService clubService;
    
    public ClubController(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;

    }    

    // http://localhost:8090/club/list
    @GetMapping(value="/club/list")
    public ResponseEntity<Map<String, Object>> listExecute(){
        Map<String, Object> map = new HashMap<>();
 		
   		map.put("clubList", clubService.listClub());

    	return ResponseEntity.ok().body(map);
    }//end listExecute()//////    
    
    @GetMapping(value="/club/view/{clubNo}")
    public ResponseEntity<ClubDTO> viewExecute(@PathVariable("clubNo") Long clubNo){
    	ClubDTO clubDTO = clubService.contentClub(clubNo);
    	return ResponseEntity.ok(clubDTO);
    }    
    
}
