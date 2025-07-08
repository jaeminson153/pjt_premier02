package com.example.pjt_premier02.club.service;

import java.util.List;

import com.example.pjt_premier02.club.dto.ClubDTO;

public interface ClubService {
	public List<ClubDTO> listClub();
	public ClubDTO contentClub(long clubNo);
}
