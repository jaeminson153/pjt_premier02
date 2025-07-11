package com.example.pjt_premier02.players.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.example.pjt_premier02.players.dto.PlayersDTO;
import com.example.pjt_premier02.players.service.PlayersService;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayersController {

    @Autowired
    private PlayersService playersService;

    // 구단별 선수 조회
    @GetMapping("/{clubNo}")
    public ResponseEntity<List<PlayersDTO>> getPlayersByClub(
            @PathVariable("clubNo") Integer clubNo) {
        List<PlayersDTO> list = playersService.getByClubNo(clubNo);
        return ResponseEntity.ok(list);
    }

    // 선수 상세 정보 조회
    @GetMapping("/{clubNo}/{playerNo}")
    public ResponseEntity<PlayersDTO> getPlayerDetail(
            @PathVariable("clubNo") Integer clubNo,
            @PathVariable("playerNo") Integer playerNo) {
        PlayersDTO dto = playersService.getByClubNoAndPlayerNo(clubNo, playerNo);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/update/{clubNo}/{playerNo}")
    public ResponseEntity<PlayersDTO> updatePlayerInfo(
            @PathVariable("clubNo") Integer clubNo,
            @PathVariable("playerNo") Integer playerNo,
            @ModelAttribute PlayersDTO playerDTO, // 폼 필드
            @RequestParam(value = "filename", required = false) MultipartFile file // 이미지
    ) {
        PlayersDTO updatedPlayer = playersService.updatePlayer(clubNo, playerNo, playerDTO, file);

        if (updatedPlayer == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(updatedPlayer);
    }
}




