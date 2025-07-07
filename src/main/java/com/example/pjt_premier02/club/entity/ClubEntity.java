package com.example.pjt_premier02.club.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "board")
public class ClubEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "club_seq_generator")
	@SequenceGenerator(name = "club_seq_generator", sequenceName = "club_no_seq", allocationSize = 1)
	private Long clubNo;
	private String clubName;
	private String homeCity;
	private Integer year;
	private String stadium;
	private String headCoach;
	private Integer captain;
	private String imfomation;
	private String imgPath;	
	private String upload;
	
}

