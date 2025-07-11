package com.example.pjt_premier02.players.service;

import com.example.pjt_premier02.players.dto.PlayersDTO;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface PlayersService {
    List<PlayersDTO> getByClubNo(Integer clubNo);
    PlayersDTO getByClubNoAndPlayerNo(Integer clubNo, Integer playerNo);
    PlayersDTO updatePlayer(Integer clubNo, Integer playerNo, PlayersDTO playerDTO, MultipartFile file);
}
