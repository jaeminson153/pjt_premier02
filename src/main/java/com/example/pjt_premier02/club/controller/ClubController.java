package com.example.pjt_premier02.club.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.pjt_premier02.club.dto.ClubDTO;
import com.example.pjt_premier02.club.repository.ClubRepository;
import com.example.pjt_premier02.club.service.ClubService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
//@CrossOrigin(origins = "http://localhost:3000")  // 허용할 프론트엔드 주소와 포트
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
    
    // 로그인후, 구단정보 수정
    @PostMapping("/club/update/{clubNo}")
    public ResponseEntity<?> updateClub(
        @PathVariable("clubNo") Long clubNo,
        @ModelAttribute ClubDTO clubDto // 핵심 : MultipartFile 포함
    ) {
        clubService.updateClub(clubNo, clubDto);
        return ResponseEntity.ok("수정 완료");
    }
}
