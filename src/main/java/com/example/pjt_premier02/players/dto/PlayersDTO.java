package com.example.pjt_premier02.players.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayersDTO {
	private Integer playerNo;
	private Integer clubNo;
	private String name;
	private Integer age;
	private String nation;
	private String position;
	private Integer height;
	private Integer weight;
	private Integer backNumber;
	private String imgPath;
}
