package com.example.pjt_premier02.league.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "league")
public class LeagueEntity {
	@Id
	private Long clubNo;
	private String clubName;
	private Integer points;
	private Integer win;
	private Integer draw;
	private Integer loss;
	private Integer score;
	private Integer conced;
}
