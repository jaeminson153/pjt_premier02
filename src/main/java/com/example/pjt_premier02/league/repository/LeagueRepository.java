package com.example.pjt_premier02.league.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.pjt_premier02.league.entity.LeagEntity;
import com.example.pjt_premier02.league.entity.LeagueEntity;

@Repository
public interface LeagueRepository extends JpaRepository<LeagueEntity, Long>{
	
	//리그순위 전체 리스트 보기 	
	@Query(value="SELECT a.club_no, b.club_name, (a.win*3 + a.draw) points,  a.win, a.draw, a.loss, a.score, a.conced FROM league a , club b where a.club_no = b.club_no", nativeQuery = true)
	List<LeagueEntity> findLeagueList();
	
	//리그순위 상세보기  	
	@Query(value="SELECT b FROM LeagueEntity b where b.clubNo = :clubNo")
	LeagueEntity findLeagueByClub(@Param("clubNo") long clubNo);	
	
	//리그순위 상세보기  	
	@Query(value="SELECT a.club_no, a.win, a.draw, a.loss, a.score, a.conced FROM league a , club b where a.club_no = b.club_no and b.club_no =:clubNo", nativeQuery = true)
	Optional<LeagEntity> findLeagueByClubNo(@Param("clubNo") long clubNo);	
	
	//리그순위 수정  
	@Modifying
	@Query(value ="""
			UPDATE League b 
			SET b.win = :#{#league.win},
				b.draw = :#{#league.draw},
				b.loss = :#{#league.loss}
			WHERE b.club_no = :#{#league.clubNo} 
			""", nativeQuery = true)
	void upLeague(@Param("league") LeagEntity league);	
		
	
}
