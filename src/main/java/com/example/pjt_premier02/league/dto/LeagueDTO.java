package com.example.pjt_premier02.league.dto;

import org.springframework.stereotype.Component;

import com.example.pjt_premier02.league.entity.LeagueEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Component
public class LeagueDTO {
	private Long clubNo;
	private String clubName;
	private Integer points;
	private Integer win;
	private Integer draw;
	private Integer loss;
	private Integer score;
	private Integer conced;
	
	
	// DTO -> Entity
	public LeagueEntity toEntity() {
		return LeagueEntity.builder()
				.clubNo(clubNo)
				.clubName(clubName)
				.points(points)
				.win(win)
				.draw(draw)
				.loss(loss)
				.score(score)
				.conced(conced)
				.build();
	}		
	
	// Entity -> DTO
	public static LeagueDTO toDTO(LeagueEntity leagueEntity) {
		return LeagueDTO.builder()
				.clubNo(leagueEntity.getClubNo())
				.clubName(leagueEntity.getClubName())
				.points(leagueEntity.getPoints())
				.win(leagueEntity.getWin())
				.draw(leagueEntity.getDraw())
				.loss(leagueEntity.getLoss())
				.score(leagueEntity.getScore())
				.conced(leagueEntity.getConced())
				.build();
	}		
	
}
