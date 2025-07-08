package com.example.pjt_premier02.players.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pjt_premier02.players.dto.PlayersDTO;
import com.example.pjt_premier02.players.entity.PlayersEntity;
import com.example.pjt_premier02.players.repository.PlayersRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Transactional
@Slf4j
@Service
public class PlayersServiceImpl implements PlayersService{

	@Autowired
	private PlayersRepository playersRepository;
	
	public PlayersServiceImpl() {
	
	}

	@Override
	public PlayersDTO getByPlayerNo(Integer playerNo) {
		Optional<PlayersEntity> optPlayersEntity = playersRepository.findById(playerNo);
		return PlayersDTO.toDTO(optPlayersEntity.get());
	}

	@Override
	public List<PlayersDTO> getByClubNo(Integer clubNo) {
	    // 1. clubNo로 선수 목록 가져오기
	    List<PlayersEntity> entityList = playersRepository.findByClubNo(clubNo);

	    // 2. entityList -> dtoList로 변환
	    List<PlayersDTO> dtoList = entityList.stream()
	                                         .map(PlayersDTO::toDTO)
	                                         .collect(Collectors.toList());

	    // 3. 반환
	    return dtoList;
	}

	

}
