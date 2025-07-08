package com.example.pjt_premier02.players.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.pjt_premier02.players.dto.PlayersDTO;
import com.example.pjt_premier02.players.service.PlayersService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class PlayersController {
	@Autowired
	private PlayersService playersService;
	
	//선수번호로 선수정보 가져오기
	@GetMapping("/players/{playerNo}")
	public ResponseEntity<PlayersDTO> getPlayer(@PathVariable Integer playerNo) {
	    PlayersDTO playerDTO = playersService.getByPlayerNo(playerNo);
	    
	    return ResponseEntity.ok(playerDTO);
	}
	
	//구단번호로 구단에 포함된 선수리스트 가져오기
    @GetMapping("/club/{clubNo}")
    public ResponseEntity<List<PlayersDTO>> getPlayersByClub(@PathVariable Integer clubNo) {
        List<PlayersDTO> players = playersService.getByClubNo(clubNo);
        return ResponseEntity.ok(players);
    }
}
