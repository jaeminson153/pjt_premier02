package com.example.pjt_premier02.club.dto;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.example.pjt_premier02.club.entity.ClubEntity;

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
public class ClubDTO {
	private Long clubNo;
	private String clubName;
	private String homeCity;
	private Integer year;
	private String stadium;
	private String headCoach;
	private Integer captain;
	private String infomation;
	private String imgPath;	
	
	// 클라이언트 MultipartFile 보냄 ->  DB에 저장 String 
	//board테이블의 파일 첨부를 처리해주는 멤버변수
	private String upload;

	//form페이지에서 파일첨부를 받아 처리해주는 멤버변수
	private MultipartFile filename;  
	
	
	// DTO -> Entity
	public ClubEntity toEntity() {
		return ClubEntity.builder()
				.clubNo(clubNo)
				.clubName(clubName)
				.homeCity(homeCity)
				.year(year)
				.stadium(stadium)
				.headCoach(headCoach)
				.captain(captain)
				.infomation(infomation)
				.imgPath(imgPath)
				.build();
	}	
	
	// Entity -> DTO
	public static ClubDTO toDTO(ClubEntity clubEntity) {
		return ClubDTO.builder()
				.clubNo(clubEntity.getClubNo())
				.clubName(clubEntity.getClubName())
				.homeCity(clubEntity.getHomeCity())
				.year(clubEntity.getYear())
				.stadium(clubEntity.getStadium())
				.headCoach(clubEntity.getHeadCoach())
				.captain(clubEntity.getCaptain())
				.infomation(clubEntity.getInfomation())				
				.imgPath(clubEntity.getImgPath())
				.build();
	}	
}
