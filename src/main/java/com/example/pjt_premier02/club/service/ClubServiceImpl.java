package com.example.pjt_premier02.club.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pjt_premier02.club.dto.ClubDTO;
import com.example.pjt_premier02.club.entity.ClubEntity;
import com.example.pjt_premier02.club.repository.ClubRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ClubServiceImpl implements ClubService{
	@Autowired
	private ClubRepository clubRepository;
	
	public ClubServiceImpl() {
	
	}
	
	@Transactional
	@Override
	public List<ClubDTO> listClub() {
		List<ClubEntity> listClubEntity = clubRepository.findClubList();
		List<ClubDTO> listClubDTO = listClubEntity.stream().map(ClubDTO::toDTO).collect(Collectors.toList());

		return listClubDTO;
	}

	@Override
	public ClubDTO contentClub(long clubNo) {
		ClubEntity clubEntity = clubRepository.findClubByClubNo(clubNo);
		return ClubDTO.toDTO(clubEntity);		
		
	}	
}
