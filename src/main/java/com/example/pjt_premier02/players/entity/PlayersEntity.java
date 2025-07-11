package com.example.pjt_premier02.players.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
@Entity
@Table(name = "player")
@IdClass(PlayersId.class) // 복합키 클래스 지정
public class PlayersEntity {
	
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_seq_generator")
	@SequenceGenerator(name = "player_seq_generator", sequenceName = "player_no_seq", allocationSize = 1)
	@Id
	private Integer playerNo; // 선수번호
	
	@Id
	private Integer clubNo; // 구단번호
	
	private String name; // 이름
	private Integer age; // 나이
	private String nation; // 국가
	private String position; // 포지션
	private Integer height; // 키
	private Integer weight; // 몸무게
	private Integer backNumber; // 등번호
	private String imgPath; // 사진경로
		

}
