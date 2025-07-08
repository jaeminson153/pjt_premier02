package com.example.pjt_premier02.club.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.pjt_premier02.club.entity.ClubEntity;

@Repository
public interface ClubRepository extends JpaRepository<ClubEntity, Long> {

	//클럽 전체 리스트 보기 	
	@Query(value="SELECT b FROM ClubEntity b ")
	List<ClubEntity> findClubList();
	
	//클럽 상세보기  	
	@Query(value="SELECT b FROM ClubEntity b where b.clubNo =:clubNo")
	ClubEntity findClubByClubNo(@Param("clubNo") long clubNo);	
}
