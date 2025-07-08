package com.example.pjt_premier02.players.service;

import java.util.List;

import com.example.pjt_premier02.players.dto.PlayersDTO;

public interface PlayersService {
	public PlayersDTO getByPlayerNo(Integer playerNo);
	public List<PlayersDTO> getByClubNo(Integer clubNo);
}
