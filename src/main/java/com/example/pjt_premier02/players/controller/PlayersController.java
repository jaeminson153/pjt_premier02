package com.example.pjt_premier02.players.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.pjt_premier02.players.dto.PlayersDTO;
import com.example.pjt_premier02.players.service.PlayersService;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayersController {
    @Autowired
    private PlayersService playersService;

    @GetMapping("/{clubNo}/{clubName}")
    public ResponseEntity<List<PlayersDTO>> getPlayersByClub(
            @PathVariable("clubNo") Integer clubNo,
            @PathVariable("clubName") String clubName) {
        List<PlayersDTO> list = playersService.getByClubNo(clubNo);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{clubNo}/{clubName}/{playerNo}")
    public ResponseEntity<PlayersDTO> getPlayerDetail(
            @PathVariable("clubNo") Integer clubNo,
            @PathVariable("clubName") String clubName,
            @PathVariable("playerNo") Integer playerNo) {
        PlayersDTO dto = playersService.getByClubNoAndPlayerNo(clubNo, playerNo);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }
}
