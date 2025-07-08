package com.example.pjt_premier02.players.dto;

import com.example.pjt_premier02.players.entity.PlayersEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class PlayersDTO {
	private Integer playerNo; // 선수번호
	private Integer clubNo; // 구단번호
	private String name; // 이름
	private Integer age; // 나이
	private String nation; // 국가
	private String position; // 포지션
	private Integer height; // 키
	private Integer weight; // 몸무게
	private Integer backNumber; // 등번호
	private String imgPath; // 사진경로
	
	// DTO -> Entity
	public PlayersEntity toEntity() {
		return PlayersEntity.builder()
				.playerNo(playerNo)
				.clubNo(clubNo)
				.name(name)
				.age(age)
				.nation(nation)
				.position(position)
				.height(height)
				.weight(weight)
				.backNumber(backNumber)
				.imgPath(imgPath)
				.build();
	}
	
	// Entity -> DTO
	public static PlayersDTO toDTO(PlayersEntity playersEntity) {
		return PlayersDTO.builder()
				.playerNo(playersEntity.getPlayerNo())
				.clubNo(playersEntity.getClubNo())
				.name(playersEntity.getName())
				.age(playersEntity.getAge())
				.nation(playersEntity.getNation())
				.position(playersEntity.getPosition())
				.height(playersEntity.getHeight())
				.weight(playersEntity.getWeight())
				.backNumber(playersEntity.getBackNumber())
				.imgPath(playersEntity.getImgPath())
				.build();
	}
		
}
	
