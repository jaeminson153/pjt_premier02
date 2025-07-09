package com.example.pjt_premier02.players.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.pjt_premier02.players.repository.PlayersRepository;
import com.example.pjt_premier02.players.dto.PlayersDTO;
import com.example.pjt_premier02.players.entity.PlayersEntity;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayersServiceImpl implements PlayersService {
    @Autowired
    private PlayersRepository playersRepository;

    @Override
    public List<PlayersDTO> getByClubNo(Integer clubNo) {
        return playersRepository.findByClubNo(clubNo)
            .stream()
            .map(this::toDTO)
            .collect(Collectors.toList());
    }

    @Override
    public PlayersDTO getByClubNoAndPlayerNo(Integer clubNo, Integer playerNo) {
        PlayersEntity entity = playersRepository.findByClubNoAndPlayerNo(clubNo, playerNo);
        return (entity != null) ? toDTO(entity) : null;
    }

    private PlayersDTO toDTO(PlayersEntity e) {
        return PlayersDTO.builder()
            .playerNo(e.getPlayerNo())
            .clubNo(e.getClubNo())
            .name(e.getName())
            .age(e.getAge())
            .nation(e.getNation())
            .position(e.getPosition())
            .height(e.getHeight())
            .weight(e.getWeight())
            .backNumber(e.getBackNumber())
            .imgPath(e.getImgPath())
            .build();
    }
}
