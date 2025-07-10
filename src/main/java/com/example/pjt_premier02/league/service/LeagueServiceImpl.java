package com.example.pjt_premier02.league.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pjt_premier02.league.dto.LeagueDTO;
import com.example.pjt_premier02.league.entity.LeagEntity;
import com.example.pjt_premier02.league.entity.LeagueEntity;
import com.example.pjt_premier02.league.repository.LeagueRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LeagueServiceImpl implements LeagueService{
	@Autowired
	private LeagueRepository leagueRepository;	
	
	public LeagueServiceImpl() {
	
	}

	@Override
	public List<LeagueDTO> listLeague() {
		List<LeagueEntity> listLeagueEntity = leagueRepository.findLeagueList();
		List<LeagueDTO> listLeagueDTO = listLeagueEntity.stream().map(LeagueDTO::toDTO).collect(Collectors.toList());

		return listLeagueDTO;
	}

	@Override
	public LeagueDTO contentLeague(long clubNo) {
		LeagueEntity leagueEntity = leagueRepository.findLeagueByClub(clubNo);
		return LeagueDTO.toDTO(leagueEntity);	
	}

	@Transactional
	@Override
	public void upProcess(List<LeagueDTO> leagueList) {
		
	    for (LeagueDTO dto : leagueList) {
	        Long clubNo = dto.getClubNo();

	        // clubNo에 해당하는 기존 데이터 조회
	        Optional<LeagEntity> optionalLeague = leagueRepository.findLeagueByClubNo(clubNo); 

	        if (optionalLeague.isPresent()) {
	            LeagEntity entity = optionalLeague.get();
	            entity.setWin(dto.getWin());
	            entity.setDraw(dto.getDraw());
	            entity.setLoss(dto.getLoss());	            
	            leagueRepository.upLeague(entity); // JPA는 save가 update 역할도 수행함
	        } else {
	            // clubNo가 DB에 없는 경우 처리 (선택 사항)
	            System.out.println("해당 clubNo 없음: " + clubNo);
	        }
	    }		
		
		//LeagueEntity leagueEntity = dto.toEntity();
		//leagueRepository.updateLeague(leagueEntity);	
		
	}
	

	

}
